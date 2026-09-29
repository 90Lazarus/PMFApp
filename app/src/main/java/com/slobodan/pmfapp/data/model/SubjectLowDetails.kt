package com.slobodan.pmfapp.data.model

import androidx.room.ColumnInfo

data class SubjectLowDetails(
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "sifra")
    val code: String,

    @ColumnInfo(name = "naziv")
    val name: String,

    @ColumnInfo(name = "status")
    val status: String?,

    @ColumnInfo(name = "semestar")
    val semester: Int,

    @ColumnInfo(name = "espb")
    val espb: Int,

    @ColumnInfo(name = "br_predavanja")
    val numLessons: Int?,

    @ColumnInfo(name = "br_vezbe")
    val numPractice: Int?,

    @ColumnInfo(name = "br_don")
    val numDon: Int?,

    @ColumnInfo(name = "br_ostalo")
    val numRest: Int?

//    @ColumnInfo(name = "studijski_program_id")
//    val studyProgramId: Int
)