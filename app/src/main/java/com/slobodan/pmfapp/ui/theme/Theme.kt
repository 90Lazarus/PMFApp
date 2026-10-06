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

private val LightColorScheme2 = lightColorScheme(
    primary = Color(0xFF075985),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF8ED0F0),
    onPrimaryContainer = Color(0xFF032B3F),

    secondary = Color(0xFF49677A),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFBFD8E5),
    onSecondaryContainer = Color(0xFF122A38),

    tertiary = Color(0xFF8A641C),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFF0D58A),
    onTertiaryContainer = Color(0xFF281B05),

    background = Color(0xFFF4F6F7),
    onBackground = Color(0xFF121A1E),

    surface = Color.White,
    onSurface = Color(0xFF121A1E),

    surfaceVariant = Color(0xFFD9E1E5),
    onSurfaceVariant = Color(0xFF35434A)
)

private val LightColorScheme3 = lightColorScheme(
    primary = Color(0xFF075985),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF8DD3F5),
    onPrimaryContainer = Color(0xFF022B3D),

    secondary = Color(0xFF176B87),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFB2E3F3),
    onSecondaryContainer = Color(0xFF052B38),

    tertiary = Color(0xFF304B63),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFC7D8E7),
    onTertiaryContainer = Color(0xFF101F2B),

    background = Color(0xFFEAF4F8),
    onBackground = Color(0xFF0D1B22),

    surface = Color(0xFFF9FCFD),
    onSurface = Color(0xFF0D1B22),

    surfaceVariant = Color(0xFFC8DCE4),
    onSurfaceVariant = Color(0xFF263C45)
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
    tertiaryContainer = Color(0xFF57524D),
    onTertiaryContainer = Color(0xFFF0E4D4),

    background = Color(0xFF12181D),
    onBackground = Color(0xFFE8ECEE),

    surface = Color(0xFF1C242A),
    onSurface = Color(0xFFE8ECEE),

    surfaceVariant = Color(0xFF303B42),
    onSurfaceVariant = Color(0xFFD0D8DC)
)

private val DarkColorScheme2 = darkColorScheme(
    primary = Color(0xFFB8C9E8),
    onPrimary = Color(0xFF101A2A),
    primaryContainer = Color(0xFF344967),
    onPrimaryContainer = Color(0xFFDCE8FF),

    secondary = Color(0xFFAAB9D0),
    onSecondary = Color(0xFF121A25),
    secondaryContainer = Color(0xFF3B4A61),
    onSecondaryContainer = Color(0xFFDCE5F3),

    tertiary = Color(0xFFB9B0D8),
    onTertiary = Color(0xFF191524),
    tertiaryContainer = Color(0xFF4B4560),
    onTertiaryContainer = Color(0xFFE8E0F7),

    background = Color(0xFF10161F),
    onBackground = Color(0xFFE5EAF2),

    surface = Color(0xFF18212C),
    onSurface = Color(0xFFE5EAF2),

    surfaceVariant = Color(0xFF2B3745),
    onSurfaceVariant = Color(0xFFC9D2DE)
)

private val DarkColorScheme3 = darkColorScheme(
    primary = Color(0xFFD0D0D0),
    onPrimary = Color(0xFF181818),
    primaryContainer = Color(0xFF4B4B4B),
    onPrimaryContainer = Color(0xFFEAEAEA),

    secondary = Color(0xFFB7B7B7),
    onSecondary = Color(0xFF191919),
    secondaryContainer = Color(0xFF414141),
    onSecondaryContainer = Color(0xFFE0E0E0),

    tertiary = Color(0xFFFFB870),
    onTertiary = Color(0xFF2A1708),
    tertiaryContainer = Color(0xFF704B2D),
    onTertiaryContainer = Color(0xFFFFDDBF),

    background = Color(0xFF141414),
    onBackground = Color(0xFFE8E8E8),

    surface = Color(0xFF1F1F1F),
    onSurface = Color(0xFFE8E8E8),

    surfaceVariant = Color(0xFF333333),
    onSurfaceVariant = Color(0xFFD0D0D0)
)

private val DarkColorScheme4 = darkColorScheme(
    primary = Color(0xFF6699B2),
    onPrimary = Color(0xFF07151C),
    primaryContainer = Color(0xFF234B5D),
    onPrimaryContainer = Color(0xFFC5DFEA),

    secondary = Color(0xFF7895A3),
    onSecondary = Color(0xFF0A151B),
    secondaryContainer = Color(0xFF30424B),
    onSecondaryContainer = Color(0xFFD0DCE1),

    tertiary = Color(0xFF557789),
    onTertiary = Color(0xFF061117),
    tertiaryContainer = Color(0xFF122B37),
    onTertiaryContainer = Color(0xFFBDD4DE),

    background = Color(0xFF050C10),
    onBackground = Color(0xFFDDE7EA),

    surface = Color(0xFF09151B),
    onSurface = Color(0xFFDDE7EA),

    surfaceVariant = Color(0xFF21343D),
    onSurfaceVariant = Color(0xFFC2D0D5)
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
        else -> LightColorScheme2
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}