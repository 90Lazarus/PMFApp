package com.slobodan.pmfapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.slobodan.pmfapp.data.entity.DegreeLevelEntity

@Dao
interface DegreeLevelDao {
    @Query("SELECT * FROM stepeni_studija")
    suspend fun getDegreeLevels(): List<DegreeLevelEntity>

//    @Query("SELECT naziv FROM stepeni_studija")
//    suspend fun getDegreeLevelNames(): List<String>
}