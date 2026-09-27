package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slobodan.pmfapp.data.model.StudyPrograms
import com.slobodan.pmfapp.viewmodel.StudyProgramViewModel

@Composable
fun ProgramScreen(
    selectedProgram: StudyPrograms,
    viewModel: StudyProgramViewModel = viewModel(factory = StudyProgramViewModel.Factory),
    onBackClick: () -> Unit
) {
    LaunchedEffect(selectedProgram) {
        viewModel.loadStudyProgram(selectedProgram)
    }
    val studyProgram by viewModel.studyProgram.collectAsState()

    Column (
    ) {
        Column(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            //Text(text = selectedProgram.displayName)
            Text(
                text = studyProgram?.name ?: "No entries in the database!",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )
        }
        //Column(
        //    modifier = Modifier.padding(12.dp).fillMaxWidth(),
        //    horizontalAlignment = Alignment.CenterHorizontally,
        //) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                    )
                }
                Button(
                    //modifier = Modifier.weight(1f),
                    //contentPadding = PaddingValues(0.dp),
                    onClick = { }
                ) { Text(text = "Svi semestri") }
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    for (i in 1..((studyProgram?.duration)?.times(2) ?: 0)) {
                        Button(
                            modifier = Modifier.weight(1f),
                            contentPadding = PaddingValues(0.dp),
                            onClick = { },
                        ) {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) { Text(text = "$i") }
                        }
                    }
                }
            }
        //}
        Row(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            //.border(border = BorderStroke(2.dp, Color.Blue)),
            horizontalArrangement = Arrangement.SpaceBetween,
            //verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Šifra predmeta")
            Text(text = "Naziv predmeta")
            Text(text = "Tip predmeta")
            Text(text = "ESPB")
        }

        //var selectedYear = remember { mutableIntStateOf(1) }
        //var subjectsForYear = biologySubjects.filter { it.semester == selectedYear.intValue }
//            Row(
//                modifier = Modifier.padding(12.dp).fillMaxWidth(),
//                //.border(border = BorderStroke(2.dp, Color.Blue)),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                //verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "Šifra predmeta")
//                Text(text = "Naziv predmeta")
//                Text(text = "Tip predmeta")
//                Text(text = "ESPB")
//            }
//            LazyColumn(
//                //
//            ) {
//                items(subjectsForYear) { subject: Subject ->
//                    Row() {
//                        Text(text = subject.code.toString(), modifier = Modifier.weight(1f))
//                        Text(text = subject.name, modifier = Modifier.weight(3f))
//                        Text(text = subject.type, modifier = Modifier.weight(1f))
//                        Text(text = subject.espb.toString(), modifier = Modifier.weight(1f))
//                    }
//                }
//            }
    }
}
