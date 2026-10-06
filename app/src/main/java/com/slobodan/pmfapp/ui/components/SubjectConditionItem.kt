package com.slobodan.pmfapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun SubjectConditionItem(
    label: String,
    condition: String?,
    onConditionClick: (String) -> Unit
) {
    val conditions = condition
        ?.split(",")
        ?.map { it.trim() }
        ?: emptyList()
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("$label: ")
        }
        withStyle(
            style = SpanStyle(
                fontFamily = MaterialTheme.typography.titleSmall.fontFamily,
                fontSize = MaterialTheme.typography.titleSmall.fontSize,
                fontWeight = FontWeight.Medium
            )
        ) {
            if (conditions.size == 1 && conditions[0].equals("Нема", ignoreCase = true)) {
                append(conditions[0])
            } else {
                conditions.forEachIndexed { index, subjectName ->
                    if (index > 0) {
                        append(", ")
                    }
                    withLink(
                        LinkAnnotation.Clickable(
                            tag = subjectName,
                            styles = TextLinkStyles(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            ),
                            linkInteractionListener = { onConditionClick(subjectName) }
                        )
                    ) {
                        append(subjectName)
                    }
                }
            }
        }
    }
    Card(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        shape = CutCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)

    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = annotatedText
        )
    }
}