package com.slobodan.pmfapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.slobodan.pmfapp.data.model.relation.StudyProgramWithDetailsWithSubjects

@Dao
interface StudyProgramDao {
    @Transaction
    @Query("SELECT * FROM studijski_programi WHERE naziv = :name")
    suspend fun getStudyProgramAll(name: String): StudyProgramWithDetailsWithSubjects?
}