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
    primary = Color(0xFF294F65),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB5CFDD),
    onPrimaryContainer = Color(0xFF071923),

    secondary = Color(0xFF465D68),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFC2D3DA),
    onSecondaryContainer = Color(0xFF0D1A20),

    tertiary = Color(0xFF705334),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFE6CCAD),
    onTertiaryContainer = Color(0xFF251608),

    background = Color(0xFFE1E6E9),
    onBackground = Color(0xFF111517),

    surface = Color(0xFFF7F8F8),
    onSurface = Color(0xFF111517),

    surfaceVariant = Color(0xFFC0CBD0),
    onSurfaceVariant = Color(0xFF293338)
)

private val LightColorScheme1 = lightColorScheme(
    primary = Color(0xFF123F63),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB7DDF5),
    onPrimaryContainer = Color(0xFF001D31),

    secondary = Color(0xFF276B8C),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFBCE7FA),
    onSecondaryContainer = Color(0xFF001E2B),

    tertiary = Color(0xFF765B32),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFEEDDBD),
    onTertiaryContainer = Color(0xFF281A05),

    background = Color(0xFFE8EEF1),
    onBackground = Color(0xFF15191C),

    surface = Color(0xFFFCFDFC),
    onSurface = Color(0xFF15191C),

    surfaceVariant = Color(0xFFC8D7DF),
    onSurfaceVariant = Color(0xFF35434A)
)

private val LightColorScheme3 = lightColorScheme(
    primary = Color(0xFF187A78),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFA8E5E0),
    onPrimaryContainer = Color(0xFF00201F),

    secondary = Color(0xFF4F6F70),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFCBE5E4),
    onSecondaryContainer = Color(0xFF0C2020),

    tertiary = Color(0xFF65734D),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFDCE6C7),
    onTertiaryContainer = Color(0xFF1B220D),

    background = Color(0xFFEAF2F0),
    onBackground = Color(0xFF171C1B),

    surface = Color(0xFFFAFDFC),
    onSurface = Color(0xFF171C1B),

    surfaceVariant = Color(0xFFD0DEDC),
    onSurfaceVariant = Color(0xFF3E4A48)
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