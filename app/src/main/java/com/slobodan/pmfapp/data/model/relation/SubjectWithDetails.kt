package com.slobodan.pmfapp.data.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.slobodan.pmfapp.data.model.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.model.entity.SubjectEntity

data class SubjectWithDetails(
    @Embedded
    val subject: SubjectEntity,

    @Relation(
        parentColumn = "studijski_program_id",
        entityColumn = "id"
    ) val studyProgram: StudyProgramEntity,
)