package com.slobodan.pmfapp.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.slobodan.pmfapp.data.entity.DegreeLevelEntity
import com.slobodan.pmfapp.data.entity.DepartmentEntity
import com.slobodan.pmfapp.data.entity.StudyProgramEntity

data class StudyProgramWithDetails(
    @Embedded
    val studyProgram: StudyProgramEntity,

    @Relation (
        parentColumn = "stepen_studija_id",
        entityColumn = "id"
    ) val degreeLevel: DegreeLevelEntity,

    @Relation (
        parentColumn = "departman_id",
        entityColumn = "id"
    ) val department: DepartmentEntity,
)
