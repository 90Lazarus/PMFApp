package com.slobodan.pmfapp.data.model

data class Subject(
    val code: Int, //unique code of the subject, this could be id maybe?
    val name: String,
    val type: String, //subjects are either Optional or Mandatory
    val optionalBlock: Int?,
    val year: Int, //on which year is the subject taken 1,2 or 3
    val semester: Int,
    val espb: Int //number of points you get when you pass the subject, a year is worth 60 points
)