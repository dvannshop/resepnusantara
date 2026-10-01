package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = SpiceRedDark,
    onPrimary = Color(0xFF5D1200),
    primaryContainer = Color(0xFF8C2707),
    onPrimaryContainer = Color(0xFFFFDBD0),
    secondary = PandanGreenDark,
    onSecondary = Color(0xFF003912),
    secondaryContainer = Color(0xFF00531D),
    onSecondaryContainer = Color(0xFF9EF39E),
    tertiary = TurmericGoldDark,
    background = DarkKitchenBackground,
    onBackground = Color(0xFFECE0DA),
    surface = DarkKitchenSurface,
    onSurface = Color(0xFFECE0DA),
    surfaceVariant = DarkKitchenCard,
    onSurfaceVariant = Color(0xFFD7C2B9),
    outline = DarkKitchenBorder
)

private val LightColorScheme = lightColorScheme(
    primary = SpiceRedPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDBD0),
    onPrimaryContainer = Color(0xFF3B0900),
    secondary = PandanGreenSecondary,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFD1FAD1),
    onSecondaryContainer = Color(0xFF002207),
    tertiary = TurmericGoldTertiary,
    background = WarmCreamBackground,
    onBackground = Color(0xFF221A15),
    surface = WarmCardSurface,
    onSurface = Color(0xFF221A15),
    surfaceVariant = Color(0xFFF9EFE7),
    onSurfaceVariant = Color(0xFF51443D),
    outline = WarmBorder
)

@Composable
fun ResepNusantaraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Use our rich Indonesian culinary theme
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
