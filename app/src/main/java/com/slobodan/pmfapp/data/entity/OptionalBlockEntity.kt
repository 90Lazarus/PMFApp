package com.slobodan.pmfapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "izborni_blokovi",
    indices = [Index("studijski_program_id")],
    foreignKeys = [
        ForeignKey(
            entity = StudyProgramEntity::class,
            parentColumns = ["id"],
            childColumns = ["studijski_program_id"]
        )
    ]
)
data class OptionalBlockEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "studijski_program_id")
    val studyProgramId: Int,

    @ColumnInfo(name = "redni_broj_bloka")
    val blockNumber: Int,

    @ColumnInfo(name = "broj_predmeta_za_izbor")
    val numberOfSubjetsToChoose: Int
)
