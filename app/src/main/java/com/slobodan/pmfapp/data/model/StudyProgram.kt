package com.slobodan.pmfapp.data.model

import com.slobodan.pmfapp.data.model.enums.DegreeLevel
import com.slobodan.pmfapp.data.model.enums.Department

//@Entity
data class StudyProgram(
    //@PrimaryKey(autoGenerate = true)
    val id: Int,

    //@ColumnInfo(name = "name")
    val name: String,

    //
    val degreeLevel: DegreeLevel,

    //
    val department: Department,

    //
    val duration: Int, //in years

    //
    val programYear: Int,

    //
    val subjects: List<Subject>
)