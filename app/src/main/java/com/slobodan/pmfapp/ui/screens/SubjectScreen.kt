package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slobodan.pmfapp.R
import com.slobodan.pmfapp.ui.components.SubjectInfoItem
import com.slobodan.pmfapp.ui.components.SubjectInfoItemMany
import com.slobodan.pmfapp.ui.components.SubjectTitleCard
import com.slobodan.pmfapp.viewmodel.SubjectViewModel

@Composable
fun SubjectScreen (
    subjectId: Int,
    viewModel: SubjectViewModel = viewModel(factory = SubjectViewModel.Factory)
) {
    LaunchedEffect(subjectId) {
        viewModel.loadSubjectById(subjectId)
    }

    val subject by viewModel.subject.collectAsState()
    val currentSubject = subject ?: run { CircularProgressIndicator(); return }

    LazyColumn() {
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_studijski_program), value = currentSubject.studyProgram.name) }
        item { SubjectTitleCard(label = stringResource(R.string.sub_info_naziv_predmeta), value = currentSubject.subject.name) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_nastavnik), value = currentSubject.subject.teacher) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_status_predmeta), value = currentSubject.subject.status) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_broj_espb), value = currentSubject.subject.espb.toString()) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_uslov), value = currentSubject.subject.condition) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_cilj_predmeta), value = "\n" + currentSubject.subject.target) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_ishod_predmeta), value = "\n" + currentSubject.subject.outcome) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_sadrzaj_predmeta), value = "\n" + currentSubject.subject.contents) }
        item { SubjectInfoItem(label = stringResource(R.string.sub_info_literatura), value = "\n" + currentSubject.subject.literature) }
        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_predavanja), value = currentSubject.subject.numLessons,
                    containerColor = MaterialTheme.colorScheme.primaryContainer)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_vezbe), value = currentSubject.subject.numPractice,
                        containerColor = MaterialTheme.colorScheme.primaryContainer)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_don), value = currentSubject.subject.numDom,
                    containerColor = MaterialTheme.colorScheme.primaryContainer)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_ostalo), value = currentSubject.subject.numRest,
                    containerColor = MaterialTheme.colorScheme.primaryContainer)
            }
        }
        item { SubjectInfoItem(stringResource(R.string.sub_info_metode_izvodjenja_nastave), value = "\n" + currentSubject.subject.method) }
        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_aktivnost), value = currentSubject.subject.activePt)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_domaci), value = currentSubject.subject.homeworkPt)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_seminari), value = currentSubject.subject.seminarPt)
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_praksa), value = currentSubject.subject.practicePt)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_projekat), value = currentSubject.subject.projectPt)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_kolokvijumi), value = currentSubject.subject.colloquiumPt)
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_pismeni), value = currentSubject.subject.writtenExamPt)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_usmeni), value = currentSubject.subject.oralExamPt)
                SubjectInfoItemMany(label = stringResource(R.string.sub_info_max_br_poena), value = currentSubject.subject.maxPt)
            }
        }
    }
}