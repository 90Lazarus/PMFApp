package com.slobodan.pmfapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.SansSerif,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
//)

//val PMFFont = FontFamily.SansSerif

val Typography = Typography().run {
    copy(
        labelSmall = labelSmall.copy(fontFamily = FontFamily.Monospace),
        labelMedium = labelMedium.copy(fontFamily = FontFamily.Monospace),
        labelLarge = labelLarge.copy(fontFamily = FontFamily.Monospace),
        headlineSmall = headlineSmall.copy(fontFamily = FontFamily.Default),
        headlineMedium = headlineMedium.copy(fontFamily = FontFamily.Default),
        headlineLarge = headlineLarge.copy(fontFamily = FontFamily.Default),
        titleSmall = titleSmall.copy(fontFamily = FontFamily.SansSerif),
        titleMedium = titleMedium.copy(fontFamily = FontFamily.SansSerif),
        titleLarge = titleLarge.copy(fontFamily = FontFamily.SansSerif),
        bodySmall = bodySmall.copy(fontFamily = FontFamily.Serif),
        bodyMedium = bodyMedium.copy(fontFamily = FontFamily.Serif),
        bodyLarge = bodyLarge.copy(fontFamily = FontFamily.Serif)
    )
}

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
