package com.slobodan.pmfapp.ui.screens

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.data.model.enums.DegreeLevel
import com.slobodan.pmfapp.data.model.enums.Department
import com.slobodan.pmfapp.ui.components.PMFAppDegreeLevelCard
import com.slobodan.pmfapp.ui.components.PMFAppHeader

@Composable
fun DepartmentsScreen(
    selectedDegree: DegreeLevel,
    onDepartmentSelected: (Department) -> Unit
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        tonalElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            PMFAppHeader()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PMFAppDegreeLevelCard(
                    name = stringResource(R.string.oas),
                    selected = selectedDegree == DegreeLevel.BACHELORS
                )
                PMFAppDegreeLevelCard(
                    name = stringResource(R.string.mas),
                    selected = selectedDegree == DegreeLevel.MASTERS
                )
                PMFAppDegreeLevelCard(
                    name = stringResource(R.string.das),
                    selected = selectedDegree == DegreeLevel.DOCTORS
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text= stringResource(R.string.odaberite_departman), style = MaterialTheme.typography.titleSmall)
                }
                Department.entries.forEach { department ->
                    Button(
                        onClick = { onDepartmentSelected(department) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                        shape = RoundedCornerShape(9.dp)
                    ) {
                        Text(
                            text = stringResource(department.displayName),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}