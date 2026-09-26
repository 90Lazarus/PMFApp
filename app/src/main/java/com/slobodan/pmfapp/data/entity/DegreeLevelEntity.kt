package com.slobodan.pmfapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
//data class DegreeLevelEntity(
//    @PrimaryKey
//    val id: Int,
//    val name: String,
//    val nameEn: String
//)

@Entity(tableName = "stepeni_studija")
data class DegreeLevelEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "naziv")
    val name: String,

    @ColumnInfo("naziv_en")
    val nameEn: String?
)