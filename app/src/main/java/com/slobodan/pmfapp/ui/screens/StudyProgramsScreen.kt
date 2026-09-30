package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.data.model.DegreeLevel
import com.slobodan.pmfapp.data.model.Department
import com.slobodan.pmfapp.data.model.StudyPrograms
import com.slobodan.pmfapp.data.source.availablePrograms
import com.slobodan.pmfapp.viewmodel.StudyProgramViewModel

@Composable
fun StudyProgramsScreen(
    selectedDegree: DegreeLevel,
    selectedDepartment: Department,
    onStudyProgramSelected: (StudyPrograms) -> Unit,
    onBackClick: () -> Unit,
    viewModel: StudyProgramViewModel = viewModel(factory = StudyProgramViewModel.Factory)
) {
    val programs = availablePrograms[selectedDegree to selectedDepartment]

    val image = when (selectedDepartment) {
        Department.BIO -> R.drawable.logo_biologija
        Department.GEO -> R.drawable.logo_geografija
        Department.MATH -> R.drawable.logo_matematika
        Department.CS -> R.drawable.logo_r_nauke
        Department.PHY -> R.drawable.logo_fizika
        Department.CHE -> R.drawable.logo_hemija
    }

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

            Spacer(modifier = Modifier.height(6.dp))

            Image(
                painter = painterResource(R.drawable.pmf_front),
                contentDescription = "University photo"
            )

            Spacer(modifier = Modifier.height(6.dp))

            Column(
                modifier = Modifier.fillMaxSize().padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().padding(6.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.padding(6.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                    Text("Odaberite studijski program:", style = MaterialTheme.typography.titleMedium)
                }

                Spacer(modifier = Modifier.height(6.dp))

                programs?.forEach { program ->
                    Button(
                        onClick = { onStudyProgramSelected(program) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = program.displayName,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}