package com.slobodan.pmfapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun SubjectInfoItem(
    label: String,
    value: String?
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {
        Text( // one text but two styles, first part should be bold, second nope
            modifier = Modifier.padding(4.dp),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                ) { append("$label: ") }
                withStyle(
                    style = SpanStyle(
                        fontSize = MaterialTheme.typography.titleSmall.fontSize,
                        fontWeight = FontWeight.Medium
                    )
                ) { append(value ?: "0") }
            }
        )
    }
}