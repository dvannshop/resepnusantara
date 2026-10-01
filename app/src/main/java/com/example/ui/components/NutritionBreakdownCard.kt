package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.RecipeEntity
import com.example.ui.theme.CalorieOrange
import com.example.ui.theme.CarbGreen
import com.example.ui.theme.FatAmber
import com.example.ui.theme.FiberPurple
import com.example.ui.theme.ProteinBlue

@Composable
fun NutritionBreakdownCard(
    recipe: RecipeEntity,
    currentServings: Int,
    onServingsChange: (Int) -> Unit,
    onLogMeal: (Double, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showMealLogDialog by remember { mutableStateOf(false) }
    var selectedMealType by remember { mutableStateOf("Makan Siang") }
    var showPerServingOnly by remember { mutableStateOf(true) }

    // Multiplier relative to original recipe servings
    val portionMultiplier = currentServings.toDouble() / recipe.servings.toDouble()

    // Calculated values
    val displayCalories = if (showPerServingOnly) recipe.calories else (recipe.calories * portionMultiplier).toInt()
    val displayProtein = if (showPerServingOnly) recipe.protein else (recipe.protein * portionMultiplier)
    val displayCarbs = if (showPerServingOnly) recipe.carbs else (recipe.carbs * portionMultiplier)
    val displayFat = if (showPerServingOnly) recipe.fat else (recipe.fat * portionMultiplier)
    val displayFiber = if (showPerServingOnly) recipe.fiber else (recipe.fiber * portionMultiplier)

    // Macro sum for percentage breakdown
    val macroTotal = displayProtein + displayCarbs + displayFat
    val proteinPercent = if (macroTotal > 0) ((displayProtein / macroTotal) * 100).toInt() else 0
    val carbsPercent = if (macroTotal > 0) ((displayCarbs / macroTotal) * 100).toInt() else 0
    val fatPercent = if (macroTotal > 0) ((displayFat / macroTotal) * 100).toInt() else 0

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header with Portions Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Kalkulator Nutrisi & Porsi",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Standar resep: ${recipe.servings} porsi",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                    )
                }

                // Interactive Portions Stepper
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilledIconButton(
                        onClick = { if (currentServings > 1) onServingsChange(currentServings - 1) },
                        modifier = Modifier.size(36.dp).testTag("servings_minus"),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Kurang Porsi",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    ) {
                        Text(
                            text = "$currentServings Porsi",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                        )
                    }

                    FilledIconButton(
                        onClick = { if (currentServings < 24) onServingsChange(currentServings + 1) },
                        modifier = Modifier.size(36.dp).testTag("servings_plus"),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Tambah Porsi",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Main Calorie Banner
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(CalorieOrange.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocalFireDepartment,
                                contentDescription = "Kalori",
                                tint = CalorieOrange,
                                modifier = Modifier.size(26.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Row(verticalAlignment = Alignment.Bottom) {
                                Text(
                                    text = "$displayCalories",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "kkal",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = CalorieOrange
                                )
                            }
                            Text(
                                text = if (showPerServingOnly) {
                                    if (currentServings != 1) "Per 1 Porsi (Total $currentServings Porsi: ${(recipe.calories * portionMultiplier).toInt()} kkal)"
                                    else "Per 1 Porsi Santapan"
                                } else {
                                    "Total Keseluruhan ($currentServings Porsi)"
                                },
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Toggle Per Porsi vs Total
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.testTag("toggle_portion_view")
                    ) {
                        Row(modifier = Modifier.padding(2.dp)) {
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = if (showPerServingOnly) MaterialTheme.colorScheme.primary else Color.Transparent,
                                modifier = Modifier.clickable { showPerServingOnly = true }
                            ) {
                                Text(
                                    text = "Per Porsi",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (showPerServingOnly) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = if (!showPerServingOnly) MaterialTheme.colorScheme.primary else Color.Transparent,
                                modifier = Modifier.clickable { showPerServingOnly = false }
                            ) {
                                Text(
                                    text = "Total Porsi",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (!showPerServingOnly) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 4 Macro Pillars: Protein, Carbs, Fat, Fiber
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MacroCardItem(
                    label = "Protein",
                    amount = String.format("%.1f", displayProtein),
                    unit = "g",
                    percent = "$proteinPercent%",
                    color = ProteinBlue,
                    modifier = Modifier.weight(1f)
                )
                MacroCardItem(
                    label = "Karbo",
                    amount = String.format("%.1f", displayCarbs),
                    unit = "g",
                    percent = "$carbsPercent%",
                    color = CarbGreen,
                    modifier = Modifier.weight(1f)
                )
                MacroCardItem(
                    label = "Lemak",
                    amount = String.format("%.1f", displayFat),
                    unit = "g",
                    percent = "$fatPercent%",
                    color = FatAmber,
                    modifier = Modifier.weight(1f)
                )
                MacroCardItem(
                    label = "Serat",
                    amount = String.format("%.1f", displayFiber),
                    unit = "g",
                    percent = "Kaya",
                    color = FiberPurple,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Macro Distribution Bar
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Proporsi Makronutrisi",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "Protein $proteinPercent% • Karbo $carbsPercent% • Lemak $fatPercent%",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                ) {
                    if (proteinPercent > 0) {
                        Box(
                            modifier = Modifier
                                .weight(proteinPercent.toFloat())
                                .height(8.dp)
                                .background(ProteinBlue)
                        )
                    }
                    if (carbsPercent > 0) {
                        Box(
                            modifier = Modifier
                                .weight(carbsPercent.toFloat())
                                .height(8.dp)
                                .background(CarbGreen)
                        )
                    }
                    if (fatPercent > 0) {
                        Box(
                            modifier = Modifier
                                .weight(fatPercent.toFloat())
                                .height(8.dp)
                                .background(FatAmber)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Action: Log to Daily Calorie Planner
            OutlinedButton(
                onClick = { showMealLogDialog = !showMealLogDialog },
                modifier = Modifier.fillMaxWidth().testTag("btn_log_meal_tracker"),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    imageVector = Icons.Default.RestaurantMenu,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (showMealLogDialog) "Tutup Pencatatan" else "Catat ke Target Kalori Hari Ini",
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Quick Meal Log Dropdown Selector
            AnimatedVisibility(visible = showMealLogDialog) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Pilih Waktu Makan:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        listOf("Sarapan", "Makan Siang", "Makan Malam", "Camilan").forEach { type ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (selectedMealType == type) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable { selectedMealType = type }
                            ) {
                                Text(
                                    text = type,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (selectedMealType == type) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(vertical = 6.dp),
                                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            onLogMeal(1.0, selectedMealType)
                            showMealLogDialog = false
                        },
                        modifier = Modifier.fillMaxWidth().testTag("btn_confirm_log_meal"),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(imageVector = Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Simpan 1 Porsi (${recipe.calories} kkal) ke $selectedMealType")
                    }
                }
            }
        }
    }
}

@Composable
private fun MacroCardItem(
    label: String,
    amount: String,
    unit: String,
    percent: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = amount,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
                Text(
                    text = unit,
                    fontSize = 10.sp,
                    color = color,
                    modifier = Modifier.padding(bottom = 1.dp)
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = percent,
                fontSize = 9.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        }
    }
}
