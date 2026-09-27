package com.slobodan.pmfapp.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.entity.SubjectEntity

data class StudyProgramWithSubjects(
    @Embedded
    val studyProgram: StudyProgramEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "studijski_program_id"
    ) val subjects: List<SubjectEntity>
)