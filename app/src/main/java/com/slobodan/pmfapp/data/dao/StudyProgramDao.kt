package com.slobodan.pmfapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.model.StudyProgram
import com.slobodan.pmfapp.data.model.StudyProgramWithDetails
import com.slobodan.pmfapp.data.model.StudyProgramWithDetailsWithSubjects
import com.slobodan.pmfapp.data.model.StudyProgramWithSubjects

@Dao
interface StudyProgramDao {
    @Transaction
    @Query("SELECT * FROM studijski_programi WHERE stepen_studija_id = :degreeLevelId AND departman_id = :departmentId")
    suspend fun getStudyProgramsWithDetails(degreeLevelId: Int, departmentId: Int): List<StudyProgramWithDetails>

    @Transaction
    @Query("SELECT * FROM studijski_programi WHERE id = :studyProgramId")
    suspend fun getStudyProgramWithSubjects(studyProgramId: Int): StudyProgramWithSubjects

    @Query("SELECT * FROM studijski_programi WHERE naziv = :name")
    suspend fun getStudyProgramByName(name: String): StudyProgramEntity?

    @Transaction
    @Query("SELECT * FROM studijski_programi WHERE naziv = :name")
    suspend fun getStudyProgramAll(name: String): StudyProgramWithDetailsWithSubjects?
}