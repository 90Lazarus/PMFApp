package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.data.model.DegreeLevel

@Composable
fun DegreeLevelsScreen(
    onDegreeSelected: (DegreeLevel) -> Unit
) {
    Surface(
        modifier = Modifier.padding(6.dp),
        shape = RoundedCornerShape(6.dp),
        tonalElevation = 4.dp,
        //border = BorderStroke(width = 1.dp, color = Color.Magenta)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.padding(6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.pmf_logo),
                    contentDescription = "University logo"
                )
                Text(text = "Prirodno-matematički fakultet u Nišu", textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineSmall)
            }

            //Spacer(modifier = Modifier.height(6.dp))

            Image(
                modifier = Modifier.padding(6.dp),
                painter = painterResource(R.drawable.pmf_front),
                contentDescription = "University photo"
            )

            //Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier.fillMaxSize().padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = stringResource(R.string.choose_degree_level), style = MaterialTheme.typography.titleMedium)

                //Spacer(modifier = Modifier.height(6.dp))

                DegreeLevel.entries.forEach { degreeLevel ->
                    Button(
                        onClick = { onDegreeSelected(degreeLevel) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = degreeLevel.displayName)
                    }
                }
//                Button(
//                    onClick = { onDegreeSelected(DegreeLevel.BACHELORS) },
//                    modifier = Modifier.fillMaxWidth(),
//                    content = { Text(text = DegreeLevel.BACHELORS.displayName) }
//                )
//
//                Button(
//                    onClick = { onDegreeSelected(DegreeLevel.MASTERS) },
//                    modifier = Modifier.fillMaxWidth(),
//                    content = { Text(text = DegreeLevel.MASTERS.displayName) }
//                )
//
//                Button(
//                    onClick = { onDegreeSelected(DegreeLevel.DOCTORS) },
//                    modifier = Modifier.fillMaxWidth(),
//                    content = { Text(text = DegreeLevel.DOCTORS.displayName) }
//                )
            }
        }
    }
}