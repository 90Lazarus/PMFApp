package com.slobodan.pmfapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.slobodan.pmfapp.data.dao.SubjectDao
import com.slobodan.pmfapp.data.entity.DegreeLevelEntity
import com.slobodan.pmfapp.data.entity.DepartmentEntity
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.entity.SubjectEntity

@Database(
    entities = [DegreeLevelEntity::class, DepartmentEntity::class, StudyProgramEntity::class, SubjectEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PMFAppDatabase : RoomDatabase() {
    abstract fun subjectDao(): SubjectDao
    companion object {
        @Volatile
        private var instance: PMFAppDatabase? = null

        fun getDatabase(context: Context): PMFAppDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    PMFAppDatabase::class.java,
                    "PMFApp.dbb"
                )
                    .createFromAsset("PMFApp.db")
                    .build()
                    .also { instance = it }
            }
        }
    }
}