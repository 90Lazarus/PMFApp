package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.data.model.enums.DegreeLevel

@Composable
fun DegreeLevelsScreen(
    onDegreeSelected: (DegreeLevel) -> Unit
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        tonalElevation = 4.dp,
        //border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.pmf_logo),
                    contentDescription = stringResource(R.string.faculty_logo_description)
                )
                Column(
                    modifier = Modifier.padding(4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.university_name),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = stringResource(R.string.faculty_name),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
            }
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                painter = painterResource(R.drawable.pmf_front),
                contentDescription = stringResource(R.string.faculty_photo),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(R.string.choose_degree_level),
                    style = MaterialTheme.typography.titleSmall
                )
                DegreeLevel.entries.forEach { degreeLevel ->
                    Button(
                        onClick = { onDegreeSelected(degreeLevel) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                        //border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primaryContainer),
                        shape = RoundedCornerShape(9.dp)
                    ) {
                        Text(
                            text = stringResource(degreeLevel.displayName),
                            style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}