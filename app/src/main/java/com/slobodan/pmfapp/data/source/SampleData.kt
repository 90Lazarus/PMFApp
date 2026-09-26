package com.slobodan.pmfapp.data.source

import com.slobodan.pmfapp.data.model.DegreeLevel
import com.slobodan.pmfapp.data.model.Department
import com.slobodan.pmfapp.data.model.StudyProgram
import com.slobodan.pmfapp.data.model.Subject

val biologySubjects = listOf(Subject(
    code = 1,
    name = "Hemija",
    type = "obavezni",
    optionalBlock = null,
    year = 2021,
    semester = 1,
    espb = 8
), Subject(
    code = 2,
    name = "Fizika",
    type = "izborni",
    optionalBlock = null,
    year = 2021,
    semester = 1,
    espb = 7
))

val biologijaOsnovne = StudyProgram(
    id = 1,
    name = "Biologija",
    degreeLevel = DegreeLevel.BACHELORS,
    department = Department.BIO,
    duration = 3,
    programYear = 2021,
    subjects = biologySubjects
)

