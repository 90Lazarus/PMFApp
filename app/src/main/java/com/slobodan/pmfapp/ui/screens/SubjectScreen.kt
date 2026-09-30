package com.slobodan.pmfapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slobodan.pmfapp.viewmodel.SubjectViewModel

@Composable
fun SubjectInfoItem(
    label: String,
    value: String?
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(6.dp)
    ) {
        Text(
            modifier = Modifier.padding(6.dp),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("$label: ")
                }
                append(value ?: "0")
            }
        )
    }
}

@Composable
fun RowScope.SubjectInfoItemMany(
    label: String,
    value: Int?,
) {
    Card(
        modifier = Modifier.weight(1f).padding(6.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(6.dp),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("$label: \n")
                }
                append((value?: 0).toString())
            }, textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SubjectTitleCard(
    title: String
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(6.dp),
        shape = CutCornerShape(6.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth().padding(6.dp)
        ) {
            Text(
                text = "Naziv predmeta: ",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = title.uppercase(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SubjectScreen (
    subjectId: Int,
    onBackClick: () -> Unit,
    viewModel: SubjectViewModel = viewModel(factory = SubjectViewModel.Factory),
) {
    LaunchedEffect(subjectId) {
        viewModel.loadSubjectById(subjectId)
    }

    val subject by viewModel.subject.collectAsState()
    val currentSubject = subject ?: run { CircularProgressIndicator(); return }

    LazyColumn() {
        item {
            Card(
                modifier = Modifier.fillMaxWidth().padding(6.dp),
                shape = CutCornerShape(6.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(3.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick) { Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back",) }
                    SubjectInfoItem(label = "Studijski program: ", value = currentSubject.studyProgram.name)
                }
            }
        }
        item{
            //Card(
            //    modifier = Modifier.fillMaxWidth().padding(6.dp),
            //    shape = CutCornerShape(6.dp)
            //) {
                SubjectTitleCard(title = currentSubject.subject.name)
            //}
        }
        item { SubjectInfoItem("Nastavnik", value = currentSubject.subject.teacher) }
        item { SubjectInfoItem("Status predmeta", value = currentSubject.subject.status) }
        item { SubjectInfoItem("Broj ESPB", value = currentSubject.subject.espb.toString()) }
        item { SubjectInfoItem("Uslov", value = currentSubject.subject.condition) }
        item { SubjectInfoItem("Cilj predmeta", value = "\n" + currentSubject.subject.target) }
        item { SubjectInfoItem("Ishod predmeta", value = "\n" + currentSubject.subject.outcome) }
        item { SubjectInfoItem("Sadržaj predmeta", value = "\n" + currentSubject.subject.contents) }
        item { SubjectInfoItem("Literatura", value = "\n" + currentSubject.subject.literature) }
        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany("Predavanja", value = currentSubject.subject.numLessons)
                SubjectInfoItemMany("Vežbe", value = currentSubject.subject.numPractice)
                SubjectInfoItemMany("DON", value = currentSubject.subject.numDom)
                SubjectInfoItemMany("Ostalo", value = currentSubject.subject.numRest)
            }
        }
        item { SubjectInfoItem("Metode izvođenja nastave", value = "\n" + currentSubject.subject.method) }
        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany("Aktivnost", value = currentSubject.subject.activePt)
                SubjectInfoItemMany("Domaći", value = currentSubject.subject.homeworkPt)
                SubjectInfoItemMany("Seminari", value = currentSubject.subject.seminarPt)
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany("Praksa", value = currentSubject.subject.practicePt)
                SubjectInfoItemMany("Projekat", value = currentSubject.subject.projectPt)
                SubjectInfoItemMany("Kolokvijumi", value = currentSubject.subject.colloquiumPt)
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubjectInfoItemMany("Pismeni", value = currentSubject.subject.writtenExamPt)
                SubjectInfoItemMany("Usmeni", value = currentSubject.subject.oralExamPt)
                SubjectInfoItemMany("Max br. poena", value = currentSubject.subject.maxPt)
            }
        }
    }
}
