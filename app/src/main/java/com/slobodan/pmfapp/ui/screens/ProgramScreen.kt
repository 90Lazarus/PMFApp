package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.slobodan.pmfapp.data.model.StudyProgram
import com.slobodan.pmfapp.data.model.StudyPrograms
import com.slobodan.pmfapp.data.model.Subject
import com.slobodan.pmfapp.data.source.biologijaOsnovne
import com.slobodan.pmfapp.data.source.availablePrograms
import com.slobodan.pmfapp.data.source.biologySubjects

@Composable
fun ProgramScreen(
    selectedProgram: StudyPrograms,
    onBackClick: () -> Unit
) {
    Text(text = selectedProgram.displayName)

    var selectedYear = remember { mutableIntStateOf(1) }
    var subjectsForYear = biologySubjects.filter { it.semester == selectedYear.intValue }

    Column() {
        Row(
            modifier = Modifier.padding(24.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 1..biologijaOsnovne.duration) {
                Button(
                    onClick = {
                        selectedYear.intValue = i
                    },
                    //modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "$i",
                        //modifier = Modifier.fillMaxWidth(),
                        //textAlign = TextAlign.Center
                    )
                }
            }
        }
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
        LazyColumn(
            //
        ) {
            items(subjectsForYear) { subject: Subject ->
                Row() {
                    Text(text = subject.code.toString(), modifier = Modifier.weight(1f))
                    Text(text = subject.name, modifier = Modifier.weight(3f))
                    Text(text = subject.type, modifier = Modifier.weight(1f))
                    Text(text = subject.espb.toString(), modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
