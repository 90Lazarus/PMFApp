package com.slobodan.pmfapp.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.SubjectInfoItemMany(
    label: String,
    value: Int?,
    containerColor: Color = MaterialTheme.colorScheme.secondaryContainer
) {
    Card(
        modifier = Modifier.weight(1f).padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontWeight = FontWeight.Bold)) {
                    append("$label: \n")
                }
                withStyle(style = SpanStyle(
                    fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    fontWeight = FontWeight.Bold)) {
                    append((value?: 0).toString())
                }
            }, textAlign = TextAlign.Center
        )
    }
}