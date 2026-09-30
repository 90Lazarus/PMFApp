package com.slobodan.pmfapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.slobodan.pmfapp.data.entity.SubjectEntity
import com.slobodan.pmfapp.data.model.SubjectLowDetails
import com.slobodan.pmfapp.data.model.SubjectWithDetails

@Dao
interface SubjectDao {
    @Query("SELECT * FROM predmeti WHERE id = :id")
    suspend fun getSubject(id: Int): SubjectEntity

    @Transaction
    @Query("SELECT * FROM predmeti WHERE id = :id")
    suspend fun getSubjectByIdWithDetails(id: Int): SubjectWithDetails

    @Transaction
    @Query("SELECT * FROM predmeti")
    suspend fun getSubjectsWithDetails(): List<SubjectWithDetails>

    @Query("SELECT id, sifra, naziv, status, izborni_blok_id, semestar, espb, br_predavanja, br_vezbe, br_don, br_ostalo FROM predmeti WHERE studijski_program_id = :studyProgramId")
    suspend fun getSubjectsLowDetails(studyProgramId: Int): List<SubjectLowDetails>

    @Transaction
    @Query("SELECT * FROM predmeti WHERE id = :subjectId")
    suspend fun getSubjectWithDetails(subjectId: Int): SubjectEntity

    @Query("SELECT * FROM predmeti WHERE id = :studyProgramId")
    suspend fun getSubjectsForStudyProgram(studyProgramId: Int): List<SubjectEntity>
}