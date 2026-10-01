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
    primary = Color(0xFF3F6278),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD0E4F0),
    onPrimaryContainer = Color(0xFF0D1D26),

    secondary = Color(0xFF536873),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFD7E5EC),
    onSecondaryContainer = Color(0xFF101C22),

    tertiary = Color(0xFF756248),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFF0DFCB),
    onTertiaryContainer = Color(0xFF281A0D),

    background = Color(0xFFF8FAFB),
    onBackground = Color(0xFF191C1E),

    surface = Color(0xFFF8FAFB),
    onSurface = Color(0xFF191C1E),
    surfaceVariant = Color(0xFFDCE4E8),
    onSurfaceVariant = Color(0xFF40484D)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFA7B0B5),
    onPrimary = Color(0xFF111416),
    primaryContainer = Color(0xFF3A4247),
    onPrimaryContainer = Color(0xFFE1E5E7),

    secondary = Color(0xFF71808A),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF344047),
    onSecondaryContainer = Color(0xFFDCE3E7),

    tertiary = Color(0xFF9A8060),
    onTertiary = Color(0xFF15110C),
    tertiaryContainer = Color(0xFF44382A),
    onTertiaryContainer = Color(0xFFE8DCCB),

    background = Color(0xFF0C1115),
    onBackground = Color(0xFFE2E6E8),

    surface = Color(0xFF151B20),
    onSurface = Color(0xFFE2E6E8),

    surfaceVariant = Color(0xFF252E34),
    onSurfaceVariant = Color(0xFFC3CCD1)
)

@Composable
fun PMFAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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