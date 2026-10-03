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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.data.model.enums.DegreeLevel
import com.slobodan.pmfapp.data.model.enums.Department
import com.slobodan.pmfapp.data.model.enums.StudyPrograms
import com.slobodan.pmfapp.data.source.availablePrograms
import com.slobodan.pmfapp.ui.components.PMFAppDegreeCard
import com.slobodan.pmfapp.ui.components.PMFAppHeader
import com.slobodan.pmfapp.viewmodel.StudyProgramViewModel

@Composable
fun StudyProgramsScreen(
    selectedDegree: DegreeLevel,
    selectedDepartment: Department,
    onStudyProgramSelected: (StudyPrograms) -> Unit,
    viewModel: StudyProgramViewModel = viewModel(factory = StudyProgramViewModel.Factory)
) {
    val programs = availablePrograms[selectedDegree to selectedDepartment]
    val image = when (selectedDepartment) {
        Department.BIO -> R.drawable.logo_biologija2
        Department.GEO -> R.drawable.logo_geografija
        Department.MATH -> R.drawable.logo_matematika
        Department.CS -> R.drawable.logo_r_nauke
        Department.PHY -> R.drawable.logo_fizika
        Department.CHE -> R.drawable.logo_hemija
    }
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(4.dp),
        tonalElevation = 4.dp,
        //border = BorderStroke(width = 1.dp, color = Color.Magenta)
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
                PMFAppDegreeCard(
                    name = stringResource(R.string.oas),
                    selected = selectedDegree == DegreeLevel.BACHELORS
                )
                PMFAppDegreeCard(
                    name = stringResource(R.string.mas),
                    selected = selectedDegree == DegreeLevel.MASTERS
                )
                PMFAppDegreeCard(
                    name = stringResource(R.string.das),
                    selected = selectedDegree == DegreeLevel.DOCTORS
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        //.weight(1f)
                        .padding(4.dp),
                    contentScale = ContentScale.Fit
                )
                Row(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(stringResource(R.string.odaberite_studijski_program),
                        style = MaterialTheme.typography.titleSmall)
                }
                programs?.forEach { program ->
                    Button(
                        onClick = { onStudyProgramSelected(program) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                        //border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primaryContainer),
                        shape = RoundedCornerShape(9.dp)
                    ) {
                        Text(text = stringResource( program.displayName),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}