package com.slobodan.pmfapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.data.model.enums.StudyPrograms
import com.slobodan.pmfapp.ui.components.StudyProgramHeaderRow
import com.slobodan.pmfapp.viewmodel.StudyProgramViewModel

@Composable
fun ProgramScreen(
    selectedProgram: StudyPrograms,
    onSubjectSelected: (Int) -> Unit,
    viewModel: StudyProgramViewModel = viewModel(factory = StudyProgramViewModel.factory)
) {
    val isLandscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

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
        var searchText by rememberSaveable { mutableStateOf("") }
        var selectedYear by rememberSaveable { mutableIntStateOf(0) }
        val filteredSubjects = studyProgram!!.subjects.filter { subject ->
            subject.name.contains(searchText, ignoreCase = true)
                    //|| subject.code.contains(searchText, ignoreCase = true)
        }
        val semestersToShow = if (searchText.isNotBlank()) {
            1..6
        } else {
            when (selectedYear) {
                0 -> 1..6
                else -> ((selectedYear * 2) - 1)..(selectedYear * 2)
            }
        }
        Surface(
            modifier = Modifier.padding(4.dp),
            shape = RoundedCornerShape(4.dp),
            tonalElevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                if(!isLandscape) {
                    Card(
                        modifier = Modifier.padding(4.dp),
                        shape = CutCornerShape(4.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer)
                    ) {
                        StudyProgramHeaderRow(
                            leftLabel = stringResource(R.string.sp_stepen_studija),
                            leftValue = studyProgram?.degreeLevel?.name,
                            rightLabel = stringResource(R.string.sp_departman),
                            rightValue = studyProgram?.department?.name
                        )
                        StudyProgramHeaderRow(
                            leftLabel = stringResource(R.string.sp_naziv_programa),
                            leftValue = studyProgram?.studyProgram?.name
                                ?: "No entries in the database!",
                            leftValueStyle = MaterialTheme.typography.headlineSmall,
                            leftWeight = 3f,
                            leftContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                            rightLabel = stringResource(R.string.sp_godina_akreditacije),
                            rightValue = studyProgram?.studyProgram?.accreditationYear?.toString(),
                            rightWeight = 1f
                        )
                        StudyProgramHeaderRow(
                            leftLabel = stringResource(R.string.sp_godine_trajanja),
                            leftValue = studyProgram?.studyProgram?.duration?.toString(),
                            rightLabel = stringResource(R.string.sp_ukupan_broj_espb_bodova),
                            rightValue = studyProgram?.studyProgram?.espb?.toString()
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                    ) {
                    Text(
                        text = stringResource(R.string.sp_odaberite_godinu),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                    for (i in 1..((studyProgram?.studyProgram?.duration) ?: 0)) {
                        FilterChip(
                            selected = selectedYear == i,
                            enabled = searchText.isBlank(),
                            onClick = { selectedYear = i },
                            label = { Text(text = "$i") }
                        )
                    }
                    FilterChip(
                        selected = selectedYear == 0,
                        enabled = searchText.isBlank(),
                        onClick = { selectedYear = 0 },
                        label = { Text(text = stringResource(R.string.sp_sve)) }
                    )
                }

                Card(
                    modifier = Modifier.padding(4.dp),
                    shape = CutCornerShape(4.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.sp_sifra_predmeta),
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Left
                        )
                        Text(
                            text = stringResource(R.string.sub_info_naziv_predmeta),
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Left
                        )
                        OutlinedTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            modifier = Modifier.weight(2.5f),
                            singleLine = true,
                            placeholder = { Text(stringResource(R.string.s_pronadji_predmet),
                                style = MaterialTheme.typography.labelMedium,
                                ) },
                            textStyle = MaterialTheme.typography.labelSmall,
                            shape = CutCornerShape(4.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                )
                            },
                            trailingIcon = {
                                if (searchText.isNotEmpty()) {
                                    IconButton(
                                        onClick = { searchText = "" }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = stringResource(R.string.dsc_delete)
                                        )
                                    }
                                }
                            }
                        )
                        Text(
                            text = stringResource(R.string.sub_info_broj_espb),
                            modifier = Modifier.weight(0.5f),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Right
                        )
                    }
                    Card(
                        //modifier = Modifier.padding(4.dp),
                        shape = CutCornerShape(4.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer)
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            items(semestersToShow.toList()) { semester ->
                                val subjectsInSemester = filteredSubjects.filter { subject ->
                                    subject.semester == semester
                                }
                                val mandatorySubjects = subjectsInSemester.filter { subject ->
                                    subject.optionalBlockId == null
                                }
                                val mandatoryCount = mandatorySubjects.size
                                val mandatoryEspb = mandatorySubjects.sumOf { subject ->
                                    subject.espb
                                }
                                val optionalBlocksInSemester = studyProgram!!.optionalBlocks.filter {
                                    block -> subjectsInSemester.any { subject ->
                                        subject.optionalBlockId == block.id
                                    }
                                }
                                val optionalCount = optionalBlocksInSemester.sumOf { block ->
                                    block.numberOfSubjetsToChoose
                                }
                                val optionalEspb = optionalBlocksInSemester.sumOf { block ->
                                    val subject = subjectsInSemester.first { subject ->
                                        subject.optionalBlockId == block.id
                                        }
                                        subject.espb * block.numberOfSubjetsToChoose
                                    }
                                val totalSubjects = mandatoryCount + optionalCount
                                val totalEspb = mandatoryEspb + optionalEspb

                                Card( //for a semester
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    shape = CutCornerShape(4.dp),
                                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "${stringResource(R.string.sp_semestar)} $semester",
                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold
                                        )
                                        mandatorySubjects.forEach { subject ->
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(4.dp)
                                            ) {
                                                Text(
                                                    text = subject.code,
                                                    modifier = Modifier.weight(1.1f),
                                                    style = MaterialTheme.typography.titleMedium,
                                                    textAlign = TextAlign.Left
                                                )
                                                Text(
                                                    text = subject.name,
                                                    modifier = Modifier
                                                        .weight(3.4f)
                                                        .clickable { onSubjectSelected(subject.id) },
                                                    color = MaterialTheme.colorScheme.tertiary,
                                                    style = MaterialTheme.typography.titleMedium,
                                                    textAlign = TextAlign.Left
                                                )
                                                Text(
                                                    text = "${subject.espb}",
                                                    modifier = Modifier.weight(0.5f),
                                                    style = MaterialTheme.typography.titleMedium,
                                                    textAlign = TextAlign.Right
                                                )
                                            }
                                        }
                                        optionalBlocksInSemester.forEach { block ->
                                            val subjectsInBlock = subjectsInSemester.filter { subject ->
                                                    subject.optionalBlockId == block.id
                                                }
                                            if (subjectsInBlock.isNotEmpty()) {
                                                Text(
                                                    text = "${stringResource(R.string.p_izborni_blok)} ${block.blockNumber} (${
                                                        stringResource(
                                                            R.string.p_bira_se
                                                        )
                                                    } ${block.numberOfSubjetsToChoose} ${
                                                        stringResource(
                                                            R.string.p_od
                                                        )
                                                    } ${subjectsInBlock.size} ${
                                                        stringResource(
                                                            R.string.p_predmeta
                                                        )
                                                    })",
                                                    modifier = Modifier.fillMaxWidth(),
                                                    style = MaterialTheme.typography.titleSmall,
                                                    textAlign = TextAlign.Center
                                                )

                                                subjectsInBlock.forEach { subject ->
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(4.dp)
                                                    ) {
                                                        Text(
                                                            text = subject.code,
                                                            modifier = Modifier.weight(1.1f),
                                                            style = MaterialTheme.typography.titleMedium,
                                                            textAlign = TextAlign.Left
                                                        )
                                                        Text(
                                                            text = subject.name,
                                                            modifier = Modifier
                                                                .weight(3.4f)
                                                                .clickable {
                                                                    onSubjectSelected(
                                                                        subject.id
                                                                    )
                                                                },
                                                            color = MaterialTheme.colorScheme.tertiary,
                                                            style = MaterialTheme.typography.titleMedium,
                                                            textAlign = TextAlign.Left
                                                        )
                                                        Text(
                                                            text = "${subject.espb}",
                                                            modifier = Modifier.weight(0.5f),
                                                            style = MaterialTheme.typography.titleMedium,
                                                            textAlign = TextAlign.Right
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(4.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "${stringResource(R.string.p_ukupan_broj_predmeta)}: $totalSubjects",
                                                modifier = Modifier.weight(1f),
                                                style = MaterialTheme.typography.labelMedium,
                                                textAlign = TextAlign.Left
                                            )
                                            Text(
                                                text = "${stringResource(R.string.p_ukupan_broj_espb)}: $totalEspb",
                                                modifier = Modifier.weight(1f),
                                                style = MaterialTheme.typography.labelMedium,
                                                textAlign = TextAlign.Right
                                            )
                                        }
                                    }
                                }
                            }
                            val subjectsInYear = studyProgram!!.subjects.filter { subject ->
                                subject.semester in semestersToShow
                            }
                            val mandatorySubjectsInYear = subjectsInYear.filter { subject ->
                                subject.optionalBlockId == null
                            }
                            val totalMandatory = mandatorySubjectsInYear.size
                            val totalMandatoryEspb = mandatorySubjectsInYear.sumOf { subject ->
                                subject.espb
                            }
                            val optionalBlocksInYear =
                                studyProgram!!.optionalBlocks.filter { block ->
                                    subjectsInYear.any { subject ->
                                        subject.optionalBlockId == block.id
                                    }
                                }
                            val totalOptional = optionalBlocksInYear.sumOf {
                                it.numberOfSubjetsToChoose
                            }
                            val totalOptionalEspb = optionalBlocksInYear.sumOf { block ->
                                val subject = subjectsInYear.first { subject ->
                                    subject.optionalBlockId == block.id
                                }
                                subject.espb * block.numberOfSubjetsToChoose
                            }
                            val totalSubjectsYear = totalMandatory + totalOptional
                            val totalEspbYear = totalMandatoryEspb + totalOptionalEspb

                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "${stringResource(R.string.p_sveukupno_predmeta)}: $totalSubjectsYear",
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Left,
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                    Text(
                                        text = "${stringResource(R.string.p_sveukupno_espb)}: $totalEspbYear",
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Right,
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}