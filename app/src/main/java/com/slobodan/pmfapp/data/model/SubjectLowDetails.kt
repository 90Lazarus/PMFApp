package com.slobodan.pmfapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Relation
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.entity.SubjectEntity

data class SubjectLowDetails(
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "sifra")
    val code: String,

    @ColumnInfo(name = "naziv")
    val name: String,

    @ColumnInfo(name = "semestar")
    val semester: Int,

    @ColumnInfo(name = "espb")
    val espb: Int
)