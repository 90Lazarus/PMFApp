package com.slobodan.pmfapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.slobodan.pmfapp.data.entity.DepartmentEntity

@Dao
interface DepartmentDao {
    @Query("SELECT * FROM departmani")
    suspend fun getDepartments(): List<DepartmentEntity>
}