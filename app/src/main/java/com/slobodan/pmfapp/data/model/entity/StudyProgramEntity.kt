package com.slobodan.pmfapp.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "studijski_programi",
    indices = [Index("stepen_studija_id"), Index("departman_id")],
    foreignKeys = [
        ForeignKey(
            entity = DegreeLevelEntity::class,
            parentColumns = ["id"],
            childColumns = ["stepen_studija_id"]
        ),
        ForeignKey(
            entity = DepartmentEntity::class,
            parentColumns = ["id"],
            childColumns = ["departman_id"]
        ),
    ]
)
data class StudyProgramEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "naziv")
    val name: String,

    @ColumnInfo(name = "naziv_en")
    val nameEn: String?,

    @ColumnInfo(name = "stepen_studija_id")
    val degreeLevelId: Int,

    @ColumnInfo(name = "departman_id")
    val departmentId: Int,

    @ColumnInfo(name = "godine_trajanja")
    val duration: Int,

    @ColumnInfo(name = "broj_espb")
    val espb: Int,

    @ColumnInfo(name = "godina_akreditacije")
    val accreditationYear: Int
)