package com.slobodan.pmfapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stepeni_studija")
data class DegreeLevelEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "naziv")
    val name: String,

    @ColumnInfo("naziv_en")
    val nameEn: String?
)