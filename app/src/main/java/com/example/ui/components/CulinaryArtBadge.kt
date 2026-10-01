package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.OutdoorGrill
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.SetMeal
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CulinaryArtBadge(
    category: String,
    badgeType: String,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp
) {
    val (gradientColors, iconVector) = when (badgeType) {
        "meat" -> Pair(
            listOf(Color(0xFFBF360C), Color(0xFF870000)),
            Icons.Default.OutdoorGrill
        )
        "poultry" -> Pair(
            listOf(Color(0xFFE65100), Color(0xFFBF360C)),
            Icons.Default.Restaurant
        )
        "seafood" -> Pair(
            listOf(Color(0xFF0277BD), Color(0xFF01579B)),
            Icons.Default.SetMeal
        )
        "cake" -> Pair(
            listOf(Color(0xFFAD1457), Color(0xFF6A1B9A)),
            Icons.Default.BakeryDining
        )
        "drink" -> Pair(
            listOf(Color(0xFF00897B), Color(0xFF004D40)),
            Icons.Default.LocalCafe
        )
        "snack" -> Pair(
            listOf(Color(0xFF2E7D32), Color(0xFF1B5E20)),
            Icons.Default.Spa
        )
        else -> Pair(
            listOf(Color(0xFFEF6C00), Color(0xFFD84315)),
            Icons.Default.LocalDining
        )
    }

    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(16.dp))
            .background(Brush.linearGradient(gradientColors)),
        contentAlignment = Alignment.Center
    ) {
        // Decorative background: miniature banana leaf platter rim & plate glow
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(this.size.width / 2f, this.size.height / 2f)
            // Platter base
            drawCircle(
                color = Color(0xFF1B5E20).copy(alpha = 0.35f),
                radius = this.size.width * 0.48f,
                center = center
            )
            // Plate inner rim
            drawCircle(
                color = Color.White.copy(alpha = 0.25f),
                radius = this.size.width * 0.40f,
                center = center
            )
            drawCircle(
                color = Color.White.copy(alpha = 0.12f),
                radius = this.size.width * 0.30f,
                center = center
            )
        }

        Icon(
            imageVector = iconVector,
            contentDescription = category,
            tint = Color.White,
            modifier = Modifier.size(size * 0.48f)
        )

    }
}
