package com.example.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.RecipeEntity
import com.example.ui.theme.CalorieOrange

@Composable
fun FinishedDishHeroVisual(
    recipe: RecipeEntity,
    modifier: Modifier = Modifier,
    height: Dp = 260.dp,
    showInteractiveZoom: Boolean = true
) {
    var isZoomed by remember { mutableStateOf(false) }

    // Subtle steam animation for hot dishes
    val infiniteTransition = rememberInfiniteTransition(label = "steam")
    val steamOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1800, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "steamOffset"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF2B1D16),
                        Color(0xFF3E2723),
                        Color(0xFF1E140F)
                    )
                )
            )
            .clickable(enabled = showInteractiveZoom) { isZoomed = true }
            .testTag("finished_dish_hero_${recipe.id}")
    ) {
        // 1. Detailed Culinary Canvas Drawing of the Plated Dish
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCulinaryScene(recipe = recipe, steamOffset = steamOffset)
        }

        // 2. Top-Left Badge: "Contoh Hasil Jadi Masakan"
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = Color.Black.copy(alpha = 0.65f),
            shadowElevation = 3.dp,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = null,
                    tint = Color(0xFFFFD54F),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Contoh Hasil Masakan Jadi",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        // 3. Top-Right: Zoom preview button
        if (showInteractiveZoom) {
            Surface(
                shape = CircleShape,
                color = Color.Black.copy(alpha = 0.65f),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
                    .clip(CircleShape)
                    .clickable { isZoomed = true }
                    .testTag("btn_zoom_finished_dish")
            ) {
                Box(modifier = Modifier.size(36.dp), contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.ZoomIn,
                        contentDescription = "Perbesar Foto",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        // 4. Bottom Info Overlay Bar (Title, Province, Calories)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.75f),
                            Color.Black.copy(alpha = 0.95f)
                        )
                    )
                )
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Place,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(11.dp)
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = recipe.province,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF2E7D32)
                        ) {
                            Text(
                                text = "Sajian Siap Hidang",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = recipe.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White,
                        maxLines = 1
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Calorie & Servings badge
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Black.copy(alpha = 0.6f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocalFireDepartment,
                            contentDescription = null,
                            tint = CalorieOrange,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "${recipe.calories} kkal",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = CalorieOrange
                        )
                    }
                }
            }
        }
    }

    // Interactive Zoom Modal Dialog
    if (isZoomed) {
        AlertDialog(
            onDismissRequest = { isZoomed = false },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Restaurant,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Visual Sajian Masakan Jadi",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    IconButton(onClick = { isZoomed = false }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Tutup")
                    }
                }
            },
            text = {
                Column {
                    // Big Magnified Preview Canvas
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                Brush.verticalGradient(
                                    listOf(Color(0xFF231610), Color(0xFF3E2723))
                                )
                            )
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawCulinaryScene(recipe = recipe, steamOffset = steamOffset)
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Khas ${recipe.province} • Standar Kuliner Tradisional",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "Panduan Plating & Penyajian:",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = getPlatingGuide(recipe),
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                lineHeight = 17.sp
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { isZoomed = false }) {
                    Text("Tutup Preview")
                }
            }
        )
    }
}

// -------------------------------------------------------------
// Detailed Compose Canvas Plating Scene Engine
// -------------------------------------------------------------
private fun DrawScope.drawCulinaryScene(recipe: RecipeEntity, steamOffset: Float) {
    val centerX = size.width / 2f
    val centerY = size.height / 2f

    // 1. Ambient Warm Spotlight Glow on dining table
    drawCircle(
        brush = Brush.radialGradient(
            colors = listOf(Color(0xFF8D4E2A).copy(alpha = 0.45f), Color.Transparent),
            center = Offset(centerX, centerY),
            radius = size.width * 0.6f
        ),
        radius = size.width * 0.6f,
        center = Offset(centerX, centerY)
    )

    // 2. Base: Fresh Emerald Banana Leaf (Daun Pisang) or Platter Mat
    val leafPath = Path().apply {
        moveTo(centerX - size.width * 0.42f, centerY + 30f)
        cubicTo(
            centerX - size.width * 0.4f, centerY - 65f,
            centerX + size.width * 0.4f, centerY - 65f,
            centerX + size.width * 0.42f, centerY + 30f
        )
        cubicTo(
            centerX + size.width * 0.38f, centerY + 85f,
            centerX - size.width * 0.38f, centerY + 85f,
            centerX - size.width * 0.42f, centerY + 30f
        )
        close()
    }

    drawPath(
        path = leafPath,
        brush = Brush.linearGradient(
            colors = listOf(Color(0xFF2E7D32), Color(0xFF1B5E20), Color(0xFF33691E)),
            start = Offset(centerX - 100f, centerY - 50f),
            end = Offset(centerX + 100f, centerY + 50f)
        )
    )

    // Banana leaf central rib vein
    drawLine(
        color = Color(0xFF558B2F),
        start = Offset(centerX - size.width * 0.35f, centerY + 5f),
        end = Offset(centerX + size.width * 0.35f, centerY + 5f),
        strokeWidth = 2.5f
    )

    // 3. Traditional Plate / Bowl Surface
    when (recipe.category) {
        "Minuman" -> {
            drawDrinkScene(centerX, centerY, recipe)
        }
        "Cake & Kue" -> {
            drawCakeScene(centerX, centerY, recipe)
        }
        "Camilan Sehat" -> {
            drawSnackScene(centerX, centerY, recipe)
        }
        else -> {
            // Makanan Utama (Meat, Poultry, Seafood, Rice, Soup)
            drawMainDishScene(centerX, centerY, recipe, steamOffset)
        }
    }
}

private fun DrawScope.drawMainDishScene(
    centerX: Float,
    centerY: Float,
    recipe: RecipeEntity,
    steamOffset: Float
) {
    val plateWidth = size.width * 0.65f
    val plateHeight = 110f

    // Plate shadow
    drawOval(
        color = Color.Black.copy(alpha = 0.45f),
        topLeft = Offset(centerX - plateWidth / 2f + 4f, centerY - 25f + 8f),
        size = Size(plateWidth, plateHeight)
    )

    // Terracotta clay pot or ceramic plate
    val isSoup = recipe.title.contains("Soto") || recipe.title.contains("Rawon") ||
            recipe.title.contains("Sup") || recipe.title.contains("Kuah") || recipe.title.contains("Gulai")

    if (isSoup) {
        // Deep clay bowl
        drawOval(
            brush = Brush.linearGradient(
                listOf(Color(0xFF4E342E), Color(0xFF3E2723), Color(0xFF1E140F))
            ),
            topLeft = Offset(centerX - plateWidth * 0.45f, centerY - 45f),
            size = Size(plateWidth * 0.9f, 95f)
        )

        // Rich aromatic broth (Dark Kluwek for Rawon, Golden Turmeric Coconut for Soto/Gulai)
        val brothColor = if (recipe.title.contains("Rawon") || recipe.title.contains("Konro")) {
            Color(0xFF261C14) // Deep kluwek black
        } else if (recipe.title.contains("Kuning") || recipe.title.contains("Gulai") || recipe.title.contains("Kari")) {
            Color(0xFFE65100) // Rich golden curry
        } else {
            Color(0xFF8D4E2A) // Savory brown broth
        }

        drawOval(
            brush = Brush.radialGradient(
                listOf(brothColor.copy(alpha = 0.95f), brothColor),
                center = Offset(centerX, centerY - 5f),
                radius = 70f
            ),
            topLeft = Offset(centerX - plateWidth * 0.38f, centerY - 35f),
            size = Size(plateWidth * 0.76f, 75f)
        )

        // Tender braised beef / chicken cubes in broth
        drawMeatChunks(centerX - 40f, centerY - 10f, Color(0xFF4E2616))
        drawMeatChunks(centerX + 30f, centerY - 15f, Color(0xFF5D2E17))
        drawMeatChunks(centerX - 5f, centerY + 5f, Color(0xFF3E1D0E))

        // Half boiled egg garnish with golden yolk
        drawOval(
            color = Color(0xFFFFF9C4),
            topLeft = Offset(centerX + 25f, centerY - 8f),
            size = Size(26f, 20f)
        )
        drawCircle(
            color = Color(0xFFFFA000),
            radius = 6.5f,
            center = Offset(centerX + 38f, centerY + 2f)
        )

        // Rising Steam plumes
        drawSteamPlumes(centerX, centerY - 40f, steamOffset)
    } else {
        // Flat Claypot Plate (Rendang, Ayam Betutu, Sate Padang, Nasi Liwet)
        drawOval(
            brush = Brush.linearGradient(
                listOf(Color(0xFF5D4037), Color(0xFF3E2723), Color(0xFF271913))
            ),
            topLeft = Offset(centerX - plateWidth / 2f, centerY - 35f),
            size = Size(plateWidth, plateHeight)
        )

        // Inner plate rim
        drawOval(
            brush = Brush.radialGradient(
                listOf(Color(0xFF2E1C14), Color(0xFF1E120D)),
                center = Offset(centerX, centerY + 15f),
                radius = 85f
            ),
            topLeft = Offset(centerX - plateWidth * 0.42f, centerY - 25f),
            size = Size(plateWidth * 0.84f, 85f)
        )

        // Plated Food Body (Caramelized Rendang meat / Betutu / Grilled Chicken)
        val meatColor = if (recipe.title.contains("Rendang")) {
            Color(0xFF36180E) // Dark caramelized rendang
        } else if (recipe.title.contains("Ikan")) {
            Color(0xFFBF360C) // Grilled spiced fish
        } else {
            Color(0xFF8B2500) // Spiced braised chicken
        }

        drawOval(
            brush = Brush.radialGradient(
                listOf(Color(0xFFC76228), meatColor),
                center = Offset(centerX - 10f, centerY + 5f),
                radius = 60f
            ),
            topLeft = Offset(centerX - 70f, centerY - 15f),
            size = Size(140f, 65f)
        )

        // Plated meat chunks & spice coating
        drawMeatChunks(centerX - 35f, centerY + 5f, Color(0xFF240E06))
        drawMeatChunks(centerX + 15f, centerY, Color(0xFF3D190B))
        drawMeatChunks(centerX - 5f, centerY + 20f, Color(0xFF1C0A04))

        // Rising subtle steam
        drawSteamPlumes(centerX, centerY - 25f, steamOffset)
    }

    // Traditional Indonesian Garnishes on Top:
    // 1. Red chili curls (Irisan Cabai Merah)
    drawArc(
        color = Color(0xFFD50000),
        startAngle = 30f,
        sweepAngle = 140f,
        useCenter = false,
        topLeft = Offset(centerX - 12f, centerY - 5f),
        size = Size(24f, 16f),
        style = Stroke(width = 3f, cap = StrokeCap.Round)
    )

    // 2. Crispy fried shallots (Taburan Bawang Goreng Keemasan)
    val shallotColor = Color(0xFFFFB74D)
    drawOval(shallotColor, Offset(centerX - 25f, centerY + 2f), Size(5f, 3f))
    drawOval(shallotColor, Offset(centerX + 18f, centerY - 2f), Size(6f, 3f))
    drawOval(shallotColor, Offset(centerX + 5f, centerY + 12f), Size(5f, 2.5f))
    drawOval(shallotColor, Offset(centerX - 15f, centerY - 10f), Size(6f, 3f))

    // 3. Fresh Kemangi / Lime Leaf garnish
    drawOval(
        color = Color(0xFF43A047),
        topLeft = Offset(centerX + 15f, centerY - 15f),
        size = Size(14f, 8f)
    )
}

private fun DrawScope.drawDrinkScene(centerX: Float, centerY: Float, recipe: RecipeEntity) {
    // Tall chilled glass
    val glassLeft = centerX - 35f
    val glassTop = centerY - 55f
    val glassWidth = 70f
    val glassHeight = 115f

    // Glass body shadow
    drawRoundRect(
        color = Color.Black.copy(alpha = 0.35f),
        topLeft = Offset(glassLeft + 4f, glassTop + 4f),
        size = Size(glassWidth, glassHeight),
        cornerRadius = CornerRadius(14f, 14f)
    )

    // Glass liquid fill based on drink type
    val liquidColor = if (recipe.title.contains("Pisang Ijo")) {
        Color(0xFFE91E63) // Vibrant red syrup + coconut milk
    } else if (recipe.title.contains("Cendol") || recipe.title.contains("Dawet")) {
        Color(0xFF43A047) // Green pandan droplets in coconut milk
    } else if (recipe.title.contains("Jahe") || recipe.title.contains("Bandrek") || recipe.title.contains("Bajigur")) {
        Color(0xFFBF360C) // Spiced warm amber tea
    } else {
        Color(0xFF00897B) // Tropical cool blend
    }

    drawRoundRect(
        brush = Brush.verticalGradient(
            listOf(
                Color.White.copy(alpha = 0.8f), // Creamy coconut milk top
                liquidColor.copy(alpha = 0.9f),
                liquidColor
            )
        ),
        topLeft = Offset(glassLeft, glassTop + 10f),
        size = Size(glassWidth, glassHeight - 10f),
        cornerRadius = CornerRadius(12f, 12f)
    )

    // Glass outline & reflection
    drawRoundRect(
        color = Color.White.copy(alpha = 0.4f),
        topLeft = Offset(glassLeft, glassTop),
        size = Size(glassWidth, glassHeight),
        cornerRadius = CornerRadius(14f, 14f),
        style = Stroke(width = 2.5f)
    )

    // Floating Ice cubes
    drawRoundRect(
        color = Color.White.copy(alpha = 0.7f),
        topLeft = Offset(centerX - 20f, glassTop + 18f),
        size = Size(16f, 14f),
        cornerRadius = CornerRadius(3f, 3f)
    )
    drawRoundRect(
        color = Color.White.copy(alpha = 0.65f),
        topLeft = Offset(centerX + 4f, glassTop + 24f),
        size = Size(14f, 14f),
        cornerRadius = CornerRadius(3f, 3f)
    )

    // Pandan leaf & drinking straw garnish
    drawLine(
        color = Color(0xFFFFB300),
        start = Offset(centerX + 18f, glassTop - 25f),
        end = Offset(centerX + 8f, glassTop + 70f),
        strokeWidth = 4f,
        cap = StrokeCap.Round
    )

    drawOval(
        color = Color(0xFF2E7D32),
        topLeft = Offset(centerX - 30f, glassTop - 15f),
        size = Size(20f, 10f)
    )
}

private fun DrawScope.drawCakeScene(centerX: Float, centerY: Float, recipe: RecipeEntity) {
    val plateWidth = size.width * 0.6f

    // Porcelain white dessert plate
    drawOval(
        brush = Brush.radialGradient(
            listOf(Color(0xFFFFFFFF), Color(0xFFE0E0E0), Color(0xFFBDBDBD)),
            center = Offset(centerX, centerY + 10f),
            radius = 80f
        ),
        topLeft = Offset(centerX - plateWidth / 2f, centerY - 25f),
        size = Size(plateWidth, 85f)
    )

    // Slices of traditional cake (Bika Ambon honeycomb / Lapis Legit layers / Serabi)
    val cakeBrush = if (recipe.title.contains("Lapis")) {
        Brush.verticalGradient(
            listOf(
                Color(0xFF5D4037), Color(0xFFFFE082),
                Color(0xFF5D4037), Color(0xFFFFE082),
                Color(0xFF5D4037), Color(0xFFFFE082)
            )
        )
    } else if (recipe.title.contains("Bika Ambon")) {
        Brush.verticalGradient(
            listOf(Color(0xFFFFA000), Color(0xFFFFD54F), Color(0xFFFF8F00))
        )
    } else {
        Brush.verticalGradient(
            listOf(Color(0xFF66BB6A), Color(0xFF43A047), Color(0xFF2E7D32)) // Pandan green
        )
    }

    drawRoundRect(
        brush = cakeBrush,
        topLeft = Offset(centerX - 45f, centerY - 20f),
        size = Size(90f, 48f),
        cornerRadius = CornerRadius(8f, 8f)
    )

    // Honeycomb dots or sesame topping
    val dotColor = Color(0xFF3E2723).copy(alpha = 0.6f)
    for (i in 0..4) {
        drawCircle(dotColor, radius = 2f, center = Offset(centerX - 30f + i * 15f, centerY - 5f))
        drawCircle(dotColor, radius = 2f, center = Offset(centerX - 25f + i * 14f, centerY + 10f))
    }

    // Pandan ribbon knot garnish
    drawOval(
        color = Color(0xFF1B5E20),
        topLeft = Offset(centerX + 25f, centerY - 32f),
        size = Size(22f, 12f)
    )
}

private fun DrawScope.drawSnackScene(centerX: Float, centerY: Float, recipe: RecipeEntity) {
    val plateWidth = size.width * 0.62f

    // Woven bamboo platter (Tampah Anyaman Bambu)
    drawOval(
        brush = Brush.radialGradient(
            listOf(Color(0xFFD7CCC8), Color(0xFFA1887F), Color(0xFF8D6E63)),
            center = Offset(centerX, centerY + 10f),
            radius = 80f
        ),
        topLeft = Offset(centerX - plateWidth / 2f, centerY - 28f),
        size = Size(plateWidth, 90f)
    )

    // Golden crispy snack pieces (Tempeh chips / Corn fritters / Tahu Gejrot)
    val snackColor = Color(0xFFFFB300)
    for (i in 0..3) {
        drawRoundRect(
            brush = Brush.linearGradient(
                listOf(Color(0xFFFFD54F), snackColor, Color(0xFFE65100))
            ),
            topLeft = Offset(centerX - 50f + i * 26f, centerY - 15f + (i % 2) * 8f),
            size = Size(32f, 32f),
            cornerRadius = CornerRadius(6f, 6f)
        )
    }

    // Fresh bird's eye chilies (Cabai Rawit Hijau)
    drawArc(
        color = Color(0xFF2E7D32),
        startAngle = 10f,
        sweepAngle = 100f,
        useCenter = false,
        topLeft = Offset(centerX + 20f, centerY + 15f),
        size = Size(20f, 12f),
        style = Stroke(width = 3.5f, cap = StrokeCap.Round)
    )
}

private fun DrawScope.drawMeatChunks(x: Float, y: Float, color: Color) {
    drawRoundRect(
        color = color,
        topLeft = Offset(x, y),
        size = Size(28f, 22f),
        cornerRadius = CornerRadius(5f, 5f)
    )
}

private fun DrawScope.drawSteamPlumes(x: Float, y: Float, offset: Float) {
    val steamColor = Color.White.copy(alpha = 0.28f)
    drawLine(
        color = steamColor,
        start = Offset(x - 20f, y + 5f),
        end = Offset(x - 25f + offset * 0.5f, y - 25f - offset),
        strokeWidth = 3f,
        cap = StrokeCap.Round
    )
    drawLine(
        color = steamColor,
        start = Offset(x, y),
        end = Offset(x + offset * 0.4f, y - 35f - offset),
        strokeWidth = 4f,
        cap = StrokeCap.Round
    )
    drawLine(
        color = steamColor,
        start = Offset(x + 20f, y + 5f),
        end = Offset(x + 25f - offset * 0.5f, y - 25f - offset),
        strokeWidth = 3f,
        cap = StrokeCap.Round
    )
}

private fun getPlatingGuide(recipe: RecipeEntity): String {
    return when (recipe.category) {
        "Makanan Utama" -> "Sajikan panas di atas piring beralas daun pisang segar. Taburi bawang merah goreng renyah dan irisan cabai merah keriting untuk kontras visual yang memikat. Dampingi dengan nasi putih pulen hangat, sambal khas daerah, dan lalapan segar."
        "Cake & Kue" -> "Tata rapi di atas piring datar atau keranjang bambu beralas daun pandan simpul. Sajikan pada suhu ruang agar tekstur lembut kenyal tetap terjaga sempurna saat digigit."
        "Minuman" -> "Tuang ke dalam gelas kaca bening dengan bongkahan es batu dingin. Beri hiasan daun pandan wangi atau serutan kelapa muda di bagian permukaan untuk sensasi menyegarkan mata dan tenggorokan."
        "Camilan Sehat" -> "Sajikan hangat di tampah anyaman beralas kertas minyak bersih. Dampingi dengan cabai rawit hijau segar atau saus cocolan alami buatan sendiri."
        else -> "Sajikan selagi hangat untuk menikmati kelezatan aroma rempah nusantara yang harum maksimal."
    }
}
