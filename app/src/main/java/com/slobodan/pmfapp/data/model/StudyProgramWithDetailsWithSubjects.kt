package com.slobodan.pmfapp.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.slobodan.pmfapp.data.entity.DegreeLevelEntity
import com.slobodan.pmfapp.data.entity.DepartmentEntity
import com.slobodan.pmfapp.data.entity.OptionalBlockEntity
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.entity.SubjectEntity

data class StudyProgramWithDetailsWithSubjects(
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

    @Relation(
        parentColumn = "id",
        entityColumn = "studijski_program_id",
    ) val optionalBlocks: List<OptionalBlockEntity>,

    @Relation(
        parentColumn = "id",
        entityColumn = "studijski_program_id",
        entity = SubjectEntity::class,
        projection = ["id", "sifra", "naziv", "status", "izborni_blok_id", "semestar", "espb", "br_predavanja", "br_vezbe", "br_don", "br_ostalo"]
    ) val subjects: List<SubjectLowDetails>
)
