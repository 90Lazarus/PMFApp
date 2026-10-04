package com.slobodan.pmfapp.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (tableName = "predmeti",
    indices = [Index("studijski_program_id", "izborni_blok_id")],
    foreignKeys = [
        ForeignKey(
            entity = StudyProgramEntity::class,
            parentColumns = ["id"],
            childColumns = ["studijski_program_id"]
        ),
        ForeignKey(
            entity = OptionalBlockEntity::class,
            parentColumns = ["id"],
            childColumns = ["izborni_blok_id"]
        )
    ])
data class SubjectEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "sifra")
    val code: String,

    @ColumnInfo(name = "studijski_program_id")
    val studyProgramId: Int,

    @ColumnInfo(name = "naziv")
    val name: String,

    @ColumnInfo(name = "naziv_en")
    val nameEn: String?,

    @ColumnInfo(name = "nastavnik")
    val teacher: String?,

    @ColumnInfo(name = "status")
    val status: String?,

    @ColumnInfo(name = "izborni_blok_id")
    val numOptBlock: Int?,

    @ColumnInfo(name = "semestar")
    val semester: Int,

    @ColumnInfo(name = "espb")
    val espb: Int,

    @ColumnInfo(name = "uslov")
    val condition: String?,

    @ColumnInfo(name = "cilj")
    val target: String?,

    @ColumnInfo(name = "ishod")
    val outcome: String?,

    @ColumnInfo(name = "sadrzaj")
    val contents: String?,

    @ColumnInfo(name = "literatura")
    val literature: String?,

    @ColumnInfo(name = "br_predavanja")
    val numLessons: Int?,

    @ColumnInfo(name = "br_vezbe")
    val numPractice: Int?,

    @ColumnInfo(name = "br_don")
    val numDom: Int?,

    @ColumnInfo(name = "br_ostalo")
    val numRest: Int?,

    @ColumnInfo(name = "metod")
    val method: String?,

    @ColumnInfo(name = "poeni_max")
    val maxPt: Int?,

    @ColumnInfo(name = "poeni_aktivnost")
    val activePt: Int?,

    @ColumnInfo(name = "poeni_praksa")
    val practicePt: Int?,

    @ColumnInfo(name = "poeni_projekat")
    val projectPt: Int?,

    @ColumnInfo(name = "poeni_kolokvijumi")
    val colloquiumPt: Int?,

    @ColumnInfo(name = "poeni_seminari")
    val seminarPt: Int?,

    @ColumnInfo(name = "poeni_domaci")
    val homeworkPt: Int?,

    @ColumnInfo(name = "poeni_pismeni")
    val writtenExamPt: Int?,

    @ColumnInfo(name = "poeni_usmeni")
    val oralExamPt: Int?
)