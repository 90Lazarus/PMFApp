package com.slobodan.pmfapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "departmani")
data class DepartmentEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "naziv")
    val name: String,

    @ColumnInfo(name = "naziv_en")
    val nameEn: String?
)