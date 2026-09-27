package com.slobodan.pmfapp.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.entity.SubjectEntity

data class SubjectWithDetails(
    @Embedded
    val subject: SubjectEntity,

    @Relation (
        parentColumn = "studijski_program_id",
        entityColumn = "id"
    ) val studyProgram: StudyProgramEntity,
)
