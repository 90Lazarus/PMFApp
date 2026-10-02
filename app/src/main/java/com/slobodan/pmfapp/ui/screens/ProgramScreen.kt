package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slobodan.pmfapp.data.model.enums.StudyPrograms
import com.slobodan.pmfapp.viewmodel.StudyProgramViewModel

@Composable
fun ProgramScreen(
    selectedProgram: StudyPrograms,
    onSubjectSelected: (Int) -> Unit,
    onBackClick: () -> Unit,
    viewModel: StudyProgramViewModel = viewModel(factory = StudyProgramViewModel.Factory)
) {
    LaunchedEffect(selectedProgram) {
        viewModel.loadStudyProgram(selectedProgram)
    }
    val studyProgram by viewModel.studyProgram.collectAsState()
    if (studyProgram == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        var selectedYear by remember { mutableIntStateOf(0) }
        val semestersToShow = when (selectedYear) {
            0 -> 1..6
            else -> ((selectedYear * 2) - 1)..(selectedYear * 2)
        }
        Surface(
            modifier = Modifier.padding(4.dp),
            shape = RoundedCornerShape(4.dp),
            tonalElevation = 4.dp,
            //border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.weight(1f).fillMaxHeight().padding(4.dp),
                        shape = CutCornerShape(4.dp)
                    )
                    {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "Stepen studija:",
                                style = MaterialTheme.typography.labelSmall,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "${studyProgram?.degreeLevel?.name}",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Card(modifier = Modifier.weight(1f).fillMaxHeight().padding(4.dp),
                        shape = CutCornerShape(4.dp))
                    {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(text = "Departman:", style = MaterialTheme.typography.labelSmall)
                            Text(
                                text = "${studyProgram?.department?.name}",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                //Text(text = selectedProgram.displayName)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.padding(4.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "Naziv programa:",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Text(
                                text = studyProgram?.studyProgram?.name
                                    ?: "No entries in the database!",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier.padding(4.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "Godina akreditacije:", textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.labelSmall
                            )
                            Text(
                                text = "${studyProgram?.studyProgram?.accreditationYear}",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.weight(1f).padding(4.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "Godine trajanja:",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Text(
                                text = "${studyProgram?.studyProgram?.duration}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier.weight(1f).padding(4.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "Ukupan broj ESPB bodova:",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Text(
                                text = "${studyProgram?.studyProgram?.espb}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Text(
                    text = "Odaberite godinu:",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
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
                        onClick = { selectedYear = 0 },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedYear == 0)
                                MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) { Text(text = "Sve") }
                    //Row(
                    //    modifier = Modifier.weight(1f)
                    //) {
                    for (i in 1..((studyProgram?.studyProgram?.duration) ?: 0)) {
                        Button(
                            //    modifier = Modifier.weight(1f),
                            //contentPadding = PaddingValues(0.dp),
                            onClick = { selectedYear = i },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedYear == i)
                                    MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.surfaceVariant
                            )
                        ) {
                            //Box(
                            //    modifier = Modifier.fillMaxWidth(),
                            //    contentAlignment = Alignment.Center
                            //) {
                            Text(text = "$i")
                        }
                    }
                }
                //}

//                Row(
//                    modifier = Modifier.padding(12.dp).fillMaxWidth(),
//                    //.border(border = BorderStroke(2.dp, Color.Blue)),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    //verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(text = "Šifra predmeta")
//                    Text(text = "Naziv predmeta")
//                    Text(text = "Tip predmeta")
//                    Text(text = "ESPB")
//                }
                Card(
                    modifier = Modifier.padding(4.dp),
                    shape = CutCornerShape(4.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Šifra predmeta",
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Naziv predmeta",
                            modifier = Modifier.weight(2f),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Tip predmeta",
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "ESPB",
                            modifier = Modifier.weight(0.5f),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center
                        )
                    }

                    Card(
                        modifier = Modifier.padding(4.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth().weight(1f)
                        ) {
                            semestersToShow.forEach { semester ->

                                val subjectsInSemester = studyProgram!!.subjects.filter {
                                    it.semester == semester
                                }
                                val mandatorySubjects = subjectsInSemester.filter {
                                    it.optionalBlockId == null
                                }
                                val mandatoryCount = mandatorySubjects.size
                                val mandatoryEspb = mandatorySubjects.sumOf {
                                    it.espb
                                }
                                val optionalCount = studyProgram!!.optionalBlocks
                                    .filter { block ->
                                        subjectsInSemester.any {
                                            it.optionalBlockId == block.id
                                        }
                                    }
                                    .sumOf { block ->
                                        block.numberOfSubjetsToChoose
                                    }
                                val optionalEspb = studyProgram!!.optionalBlocks
                                    .filter { block ->
                                        subjectsInSemester.any {
                                            it.optionalBlockId == block.id
                                        }
                                    }
                                    .sumOf { block ->
                                        val exampleSubject = subjectsInSemester.first {
                                            it.optionalBlockId == block.id
                                        }

                                        exampleSubject.espb * block.numberOfSubjetsToChoose
                                    }
                                val totalSubjects = mandatoryCount + optionalCount
                                val totalEspb = mandatoryEspb + optionalEspb

                                item {
                                    Text(
                                        text = "Semestar $semester:",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                items(studyProgram?.subjects?.filter { it.semester == semester && it.optionalBlockId == null }
                                    ?: emptyList()
                                ) { subject ->
                                    //items(studyProgram?.subjects?.count() ?: 0) { subject ->
                                    //studyProgram?.subjects?.forEach { subject ->
                                    Row(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                                        Text(
                                            text = subject.code,
                                            modifier = Modifier.weight(1f),
                                            textAlign = TextAlign.Left
                                        )
                                        Text(
                                            text = subject.name,
                                            modifier = Modifier.weight(2f)
                                                .clickable() { onSubjectSelected(subject.id) },
                                            color = MaterialTheme.colorScheme.primary,
                                            textAlign = TextAlign.Left
                                        )
                                        Text(
                                            text = "${subject.status ?: 0}",
                                            modifier = Modifier.weight(1f),
                                            textAlign = TextAlign.Center
                                        )
                                        Text(
                                            text = "${subject.espb}",
                                            modifier = Modifier.weight(0.5f),
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                }
                                studyProgram?.optionalBlocks?.filter { block ->
                                    studyProgram!!.subjects.any {
                                        it.optionalBlockId == block.id && it.semester == semester
                                    }
                                }
                                    ?.forEach { block ->
                                        val subjectsInBlock = studyProgram!!.subjects.filter {
                                            it.optionalBlockId == block.id && it.semester == semester
                                        }
                                        item {
                                            Text(
                                                text = "Izborni blok ${block.blockNumber} (bira se ${block.numberOfSubjetsToChoose} od ${subjectsInBlock.size} predemeta)",
                                                modifier = Modifier.fillMaxWidth(),
                                                style = MaterialTheme.typography.titleSmall,
                                                textAlign = TextAlign.Center
                                            )
//                                        Text(
//                                            text = "Bira se ${block.numberOfSubjetsToChoose} od ${subjectsInBlock.size} predemeta",
//                                            modifier = Modifier.fillMaxWidth(),
//                                            style = MaterialTheme.typography.bodyMedium,
//                                            textAlign = TextAlign.Center
//                                        )
                                        }
                                        items(subjectsInBlock) { subject ->
                                            Row(
                                                modifier = Modifier.fillMaxWidth().padding(4.dp)
                                            ) {
                                                Text(
                                                    text = subject.code,
                                                    modifier = Modifier.weight(1f),
                                                    textAlign = TextAlign.Left
                                                )
                                                Text(
                                                    text = subject.name,
                                                    modifier = Modifier.weight(2f)
                                                        .clickable { onSubjectSelected(subject.id) },
                                                    color = MaterialTheme.colorScheme.primary,
                                                    textAlign = TextAlign.Left
                                                )
                                                Text(
                                                    text = subject.status ?: "",
                                                    modifier = Modifier.weight(1f),
                                                    textAlign = TextAlign.Center
                                                )
                                                Text(
                                                    text = "${subject.espb}",
                                                    modifier = Modifier.weight(0.5f),
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        }
                                    }
                                item(
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().padding(4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Ukupan broj predmeta: $totalSubjects",
                                            modifier = Modifier.weight(1f),
                                            style = MaterialTheme.typography.labelMedium,
                                            textAlign = TextAlign.Left
                                        )
                                        Text(
                                            text = "Ukupan broj ESPB: $totalEspb",
                                            modifier = Modifier.weight(1f),
                                            style = MaterialTheme.typography.labelMedium,
                                            textAlign = TextAlign.Right
                                        )
                                    }
                                }

                            }
                            val subjectsInYear = studyProgram!!.subjects.filter {
                                it.semester in semestersToShow
                            }
                            val mandatorySubjectsInYear = subjectsInYear.filter {
                                it.optionalBlockId == null
                            }
                            val mandatoryCount2 = mandatorySubjectsInYear.size
                            val mandatoryEspb2 = mandatorySubjectsInYear.sumOf {
                                it.espb
                            }
                            val optionalBlocksInYear =
                                studyProgram!!.optionalBlocks.filter { block ->
                                    subjectsInYear.any {
                                        it.optionalBlockId == block.id
                                    }
                                }
                            val optionalCount2 = optionalBlocksInYear.sumOf {
                                it.numberOfSubjetsToChoose
                            }
                            val optionalEspb2 = optionalBlocksInYear.sumOf { block ->

                                val subject = subjectsInYear.first {
                                    it.optionalBlockId == block.id
                                }

                                subject.espb * block.numberOfSubjetsToChoose
                            }
                            val totalSubjectsYear = mandatoryCount2 + optionalCount2
                            val totalEspbYear = mandatoryEspb2 + optionalEspb2
                            item {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Sveukupno predmeta: $totalSubjectsYear",
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Left,
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                    Text(
                                        text = "Sveukupno ESPB: $totalEspbYear",
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Right,
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                }
                            }
                        }
//                    item {
//                        Text(
//                            text = "Semestar ${selectedYear.times(2)}",
//                            modifier = Modifier.fillMaxWidth(),
//                            textAlign = TextAlign.Center,
//                            style = MaterialTheme.typography.titleMedium
//                        )
//                    }
//                    items(subjectsForYear) { subject ->
//                        //items(studyProgram?.subjects?.count() ?: 0) { subject ->
//                        //studyProgram?.subjects?.forEach { subject ->
//                        Row(modifier = Modifier.fillMaxWidth().padding(2.dp)) {
//                            Text(
//                                text = subject.code,
//                                modifier = Modifier.weight(1f),
//                                textAlign = TextAlign.Center
//                            )
//                            Text(
//                                text = subject.name,
//                                modifier = Modifier.weight(2f).clickable() {},
//                                color = MaterialTheme.colorScheme.primary,
//                                textAlign = TextAlign.Center
//                            )
//                            Text(
//                                text = "${subject.status ?: 0}",
//                                modifier = Modifier.weight(1f),
//                                textAlign = TextAlign.Center
//                            )
//                            Text(
//                                text = "${subject.espb}",
//                                modifier = Modifier.weight(1f),
//                                textAlign = TextAlign.Center
//                            )
//                            //Text(text = "${subject.numLessons ?: 0}")
//                            //Text(text = "${subject.numPractice ?: 0}")
//                            //Text(text = "${subject.numDon ?: 0}")
//                            //Text(text = "${subject.numRest ?: 0}")
//                        }
//                    }
                    }
                }
            }
        }
    }
}