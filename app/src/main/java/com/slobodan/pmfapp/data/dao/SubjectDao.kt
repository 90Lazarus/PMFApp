package com.slobodan.pmfapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.slobodan.pmfapp.data.model.relation.SubjectWithDetails

@Dao
interface SubjectDao {
    @Transaction
    @Query("SELECT * FROM predmeti WHERE id = :id")
    suspend fun getSubjectByIdWithDetails(id: Int): SubjectWithDetails

    @Query("SELECT id FROM predmeti WHERE naziv = :name AND studijski_program_id = :studyProgramId")
    suspend fun getSubjectIdByName(name: String, studyProgramId: Int): Int?
}