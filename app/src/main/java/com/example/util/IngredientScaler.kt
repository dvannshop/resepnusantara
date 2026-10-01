package com.example.util

import java.util.Locale
import java.util.regex.Pattern

object IngredientScaler {

    // Regex for culinary units in Indonesian
    private const val UNITS_REGEX =
        "(?:kg|kilogram|kilo|gr|gram|g|ons|mg|liter|lt|l|ml|mili|cc|sdm|sdt|sendok\\s+makan|sendok\\s+teh|sendok\\s+sayur|sendok|siung|batang|lembar|buah|butir|biji|ruas|cm|tongkol|mata|gelas|cangkir|cup|mangkok|mangkuk|ekor|papan|lonjor|ikat|keping|helai|kuntum|kelopak|bungkus|sachet|saset|kemasan|kaleng|kotak|botol|paket|dus|tetes|iris|potong|jumput|cubit|genggam|suwir|porsi)"

    // Keywords that indicate dimensions or cooking instructions, NOT recipe quantities
    private val DIMENSION_KEYWORDS = listOf(
        "potong", "potongan", "iris", "irisan", "dadu", "tebal", "ketebalan",
        "diameter", "loyang", "cetakan", "oven", "suhu", "derajat", "ukuran",
        "panjang", "celcius", "celsius", "menit", "jam", "fase"
    )

    // Pattern matching a quantity at start of line or after punctuation (,;: or open bracket)
    // Matches: (delimiter/start) (whitespace) (number) (optional unit)
    // Notice: unit is optional, but whitespace before unit is part of the optional unit group,
    // so if unit is absent, trailing whitespace is NOT consumed!
    private val ITEM_QUANTITY_PATTERN = Pattern.compile(
        """(?i)(^|(?<=[,;:\n(]))\s*(\d+\s+\d+/\d+|\d+/\d+|\d+(?:[.,]\d+)?)(?:\s*($UNITS_REGEX)\b)?"""
    )

    // Secondary pattern for standalone unit patterns anywhere in text (e.g., "santan dari 3 butir kelapa")
    private val STANDALONE_UNIT_PATTERN = Pattern.compile(
        """(?i)\b(\d+\s+\d+/\d+|\d+/\d+|\d+(?:[.,]\d+)?)\s*($UNITS_REGEX)\b"""
    )

    /**
     * Scales an entire list of recipe ingredient lines based on target servings.
     */
    fun scaleIngredients(
        ingredientLines: List<String>,
        originalServings: Int,
        targetServings: Int
    ): List<String> {
        if (originalServings <= 0 || targetServings <= 0 || originalServings == targetServings) {
            return ingredientLines
        }
        val multiplier = targetServings.toDouble() / originalServings.toDouble()
        return ingredientLines.map { line -> scaleSingleLine(line, multiplier) }
    }

    /**
     * Scales a single ingredient line.
     */
    fun scaleSingleLine(line: String, multiplier: Double): String {
        val trimmed = line.trim()
        if (trimmed.isEmpty()) return line

        // Skip headers or notes ending with ':' or containing no numbers
        if (trimmed.endsWith(":") || !trimmed.any { it.isDigit() }) {
            return line
        }

        // If line is purely qualitative like "Garam dan gula secukupnya"
        val lower = trimmed.lowercase(Locale.ROOT)
        if (!trimmed.any { it.isDigit() } ||
            lower == "garam dan gula secukupnya" ||
            lower == "garam secukupnya" ||
            lower == "minyak untuk menggoreng" ||
            lower == "minyak goreng secukupnya" ||
            lower == "es batu secukupnya"
        ) {
            return line
        }

        data class ReplacementSpan(
            val start: Int,
            val end: Int,
            val originalQtyStr: String,
            val originalUnitStr: String?,
            val scaledText: String
        )

        val replacements = mutableListOf<ReplacementSpan>()

        // 1. Check item-level pattern (at start of string or after delimiters like , ; : ( )
        val matcher = ITEM_QUANTITY_PATTERN.matcher(trimmed)
        while (matcher.find()) {
            val fullMatchStart = matcher.start()
            val fullMatchEnd = matcher.end()

            val qtyStr = matcher.group(2) ?: ""
            val unitStr = matcher.group(3)

            // Start of quantity (skip leading spaces matched before the number)
            val matchedText = matcher.group(0) ?: ""
            val leadingSpacesCount = matchedText.indexOf(qtyStr)
            val qtyStart = if (leadingSpacesCount >= 0) fullMatchStart + leadingSpacesCount else fullMatchStart
            val qtyEnd = fullMatchEnd

            // Check if this number is a dimension (e.g. preceded by "potong dadu", "tebal", "loyang")
            if (isDimensionNumber(trimmed, qtyStart, qtyStr, unitStr)) {
                continue
            }

            val parsedValue = parseQuantityToDouble(qtyStr)
            if (parsedValue != null && parsedValue > 0) {
                val scaledValue = parsedValue * multiplier
                val formattedQty = formatQuantity(scaledValue)
                val replacementText = if (!unitStr.isNullOrEmpty()) {
                    "$formattedQty $unitStr"
                } else {
                    formattedQty
                }

                replacements.add(
                    ReplacementSpan(
                        start = qtyStart,
                        end = qtyEnd,
                        originalQtyStr = qtyStr,
                        originalUnitStr = unitStr,
                        scaledText = replacementText
                    )
                )
            }
        }

        // 2. Check for standalone unit patterns that might have been preceded by words like "dari 3 butir kelapa"
        val standaloneMatcher = STANDALONE_UNIT_PATTERN.matcher(trimmed)
        while (standaloneMatcher.find()) {
            val start = standaloneMatcher.start()
            val end = standaloneMatcher.end()
            val qtyStr = standaloneMatcher.group(1) ?: ""
            val unitStr = standaloneMatcher.group(2)

            // Skip if overlapping with existing replacement
            val overlaps = replacements.any { (start >= it.start && start < it.end) || (end > it.start && end <= it.end) }
            if (overlaps) continue

            // Skip if dimension
            if (isDimensionNumber(trimmed, start, qtyStr, unitStr)) {
                continue
            }

            val parsedValue = parseQuantityToDouble(qtyStr)
            if (parsedValue != null && parsedValue > 0) {
                val scaledValue = parsedValue * multiplier
                val formattedQty = formatQuantity(scaledValue)
                val replacementText = "$formattedQty $unitStr"

                replacements.add(
                    ReplacementSpan(
                        start = start,
                        end = end,
                        originalQtyStr = qtyStr,
                        originalUnitStr = unitStr,
                        scaledText = replacementText
                    )
                )
            }
        }

        if (replacements.isEmpty()) {
            return line
        }

        // Sort replacements by start index ascending
        replacements.sortBy { it.start }

        // Build result string
        val sb = StringBuilder()
        var currentIndex = 0
        for (rep in replacements) {
            if (rep.start >= currentIndex) {
                sb.append(trimmed.substring(currentIndex, rep.start))
                sb.append(rep.scaledText)
                currentIndex = rep.end
            }
        }
        if (currentIndex < trimmed.length) {
            sb.append(trimmed.substring(currentIndex))
        }

        return sb.toString()
    }

    /**
     * Checks if a number at given index is part of culinary dimensions or instructions
     * (e.g. "potong dadu 4 cm", "iris 1 cm", "loyang 20x20 cm", "suhu 180°C", "15 menit").
     */
    private fun isDimensionNumber(fullText: String, startIndex: Int, qtyStr: String, unitStr: String?): Boolean {
        // If followed by time units or temperature
        val afterText = fullText.substring((startIndex + qtyStr.length).coerceAtMost(fullText.length)).trim().lowercase(Locale.ROOT)
        if (afterText.startsWith("menit") || afterText.startsWith("jam") || afterText.startsWith("°c") || afterText.startsWith("celsius")) {
            return true
        }

        // Look back up to 25 characters for dimension keywords
        val lookbackStart = (startIndex - 25).coerceAtLeast(0)
        val beforeText = fullText.substring(lookbackStart, startIndex).lowercase(Locale.ROOT)

        for (kw in DIMENSION_KEYWORDS) {
            if (beforeText.contains(kw)) {
                // If it's something like "potong dadu 4 cm" or "loyang 20 cm", it's a dimension!
                // However, "3 cm jahe" or "2 cm lengkuas" is an ingredient quantity.
                val unitLower = unitStr?.lowercase(Locale.ROOT) ?: ""
                val isHerbMeasurement = afterText.startsWith("jahe") || afterText.startsWith("lengkuas") ||
                        afterText.startsWith("kunyit") || afterText.startsWith("kencur") ||
                        afterText.startsWith("kayu manis")

                if (unitLower == "cm" && isHerbMeasurement) {
                    return false
                }
                return true
            }
        }

        // Also check if text right before is 'x' or 'x ' like in "20x20"
        if (startIndex > 0 && (fullText[startIndex - 1] == 'x' || fullText[startIndex - 1] == 'X')) {
            return true
        }

        return false
    }

    private fun parseQuantityToDouble(str: String): Double? {
        val s = str.trim().replace(',', '.')
        return try {
            if (s.contains(" ") && s.contains("/")) {
                // Mixed fraction like "1 1/2"
                val parts = s.split("\\s+".toRegex())
                val whole = parts[0].toDouble()
                val fracParts = parts[1].split("/")
                val frac = fracParts[0].toDouble() / fracParts[1].toDouble()
                whole + frac
            } else if (s.contains("/")) {
                // Simple fraction like "1/2" or "3/4"
                val parts = s.split("/")
                parts[0].toDouble() / parts[1].toDouble()
            } else {
                s.toDouble()
            }
        } catch (e: Exception) {
            null
        }
    }

    fun formatQuantity(value: Double): String {
        // If value is virtually an integer
        val roundedInt = Math.round(value).toInt()
        val diffFromInt = Math.abs(value - roundedInt)
        if (diffFromInt < 0.05) {
            return roundedInt.toString()
        }

        // Check for common fractional values if under 10
        if (value < 10.0) {
            val whole = value.toInt()
            val fraction = value - whole

            val fracStr = when {
                Math.abs(fraction - 0.25) < 0.08 -> "1/4"
                Math.abs(fraction - 0.33) < 0.08 -> "1/3"
                Math.abs(fraction - 0.50) < 0.08 -> "1/2"
                Math.abs(fraction - 0.67) < 0.08 -> "2/3"
                Math.abs(fraction - 0.75) < 0.08 -> "3/4"
                else -> ""
            }
            if (fracStr.isNotEmpty()) {
                return if (whole > 0) "$whole $fracStr" else fracStr
            }
        }

        // Otherwise format with 1 decimal place
        val formatted = String.format(Locale.US, "%.1f", value)
        return if (formatted.endsWith(".0")) {
            formatted.substringBefore(".0")
        } else {
            formatted
        }
    }
}
