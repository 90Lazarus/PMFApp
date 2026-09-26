package com.slobodan.pmfapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.slobodan.pmfapp.data.entity.SubjectEntity

@Dao
interface SubjectDao {
    @Query("SELECT * FROM predmeti LIMIT 5")
    suspend fun getSubjects(): List<SubjectEntity>
}