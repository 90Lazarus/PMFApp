package com.slobodan.pmfapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StudyProgramHeaderRow (
    leftLabel: String,
    leftLabelStyle: TextStyle = MaterialTheme.typography.labelSmall,
    leftValue: String?,
    leftValueStyle: TextStyle = MaterialTheme.typography.labelLarge,
    leftWeight: Float = 1f,
    leftContainerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    rightLabel: String,
    rightLabelStyle: TextStyle = MaterialTheme.typography.labelSmall,
    rightValue: String?,
    rightValueStyle: TextStyle = MaterialTheme.typography.labelSmall,
    rightWeight: Float = 1f,
    rightContainerColor: Color = MaterialTheme.colorScheme.surfaceVariant
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.weight(leftWeight).fillMaxHeight().padding(4.dp),
            shape = CutCornerShape(4.dp),
            colors = CardDefaults.cardColors(containerColor = leftContainerColor)
        )
        {
            Column(
                modifier = Modifier.fillMaxSize().padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = leftLabel,
                    style = leftLabelStyle,
                    textAlign = TextAlign.Center
                )
                if (leftValue != null) {
                    Text(
                        text = leftValue,
                        style = leftValueStyle,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Card(modifier = Modifier.weight(rightWeight).fillMaxHeight().padding(4.dp),
            shape = CutCornerShape(4.dp),
            colors = CardDefaults.cardColors(containerColor = rightContainerColor)
        )
        {
            Column(
                modifier = Modifier.fillMaxSize().padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = rightLabel,
                    style = rightLabelStyle,
                    textAlign = TextAlign.Center)
                if (rightValue != null) {
                    Text(
                        text = rightValue,
                        style = rightValueStyle,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}