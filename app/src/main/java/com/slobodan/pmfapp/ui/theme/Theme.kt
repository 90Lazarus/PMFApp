package com.slobodan.pmfapp.ui.theme

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

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF315D78),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFB9D8EA),
    onPrimaryContainer = Color(0xFF0B1D29),

    secondary = Color(0xFF4E6573),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFC8D9E2),
    onSecondaryContainer = Color(0xFF101D24),

    tertiary = Color(0xFF356B73),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFB8DDE1),
    onTertiaryContainer = Color(0xFF0A2529),

    background = Color(0xFFF0F5F8),
    onBackground = Color(0xFF14191C),

    surface = Color(0xFFF8FAFB),
    onSurface = Color(0xFF14191C),

    surfaceVariant = Color(0xFFD5E0E5),
    onSurfaceVariant = Color(0xFF3E4B52)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFC2CBD0),
    onPrimary = Color(0xFF161A1D),
    primaryContainer = Color(0xFF4B565D),
    onPrimaryContainer = Color(0xFFF0F3F4),

    secondary = Color(0xFF8C9BA4),
    onSecondary = Color(0xFF151A1D),
    secondaryContainer = Color(0xFF46545C),
    onSecondaryContainer = Color(0xFFE4EAED),

    tertiary = Color(0xFFB49A78),
    onTertiary = Color(0xFF1D1710),
    tertiaryContainer = Color(0xFF5A4935),
    onTertiaryContainer = Color(0xFFF0E4D4),

    background = Color(0xFF12181D),
    onBackground = Color(0xFFE8ECEE),

    surface = Color(0xFF1C242A),
    onSurface = Color(0xFFE8ECEE),

    surfaceVariant = Color(0xFF303B42),
    onSurfaceVariant = Color(0xFFD0D8DC)
)

@Composable
fun PMFAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
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