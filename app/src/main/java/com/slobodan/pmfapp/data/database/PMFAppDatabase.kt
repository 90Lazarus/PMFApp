package com.slobodan.pmfapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.slobodan.pmfapp.data.dao.StudyProgramDao
import com.slobodan.pmfapp.data.dao.SubjectDao
import com.slobodan.pmfapp.data.model.entity.DegreeLevelEntity
import com.slobodan.pmfapp.data.model.entity.DepartmentEntity
import com.slobodan.pmfapp.data.model.entity.OptionalBlockEntity
import com.slobodan.pmfapp.data.model.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.model.entity.SubjectEntity

@Database(
    entities = [DegreeLevelEntity::class, DepartmentEntity::class, StudyProgramEntity::class, SubjectEntity::class, OptionalBlockEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PMFAppDatabase : RoomDatabase() {
    abstract fun studyProgramDao(): StudyProgramDao
    abstract fun subjectDao(): SubjectDao
    companion object {
        @Volatile
        private var database: PMFAppDatabase? = null
        fun getDatabase(context: Context): PMFAppDatabase {
            return database ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = PMFAppDatabase::class.java,
                    name = "PMFApp.db"
                )
                    .createFromAsset("PMFApp.db")
                    .build()
                    .also { database = it }
            }
        }
    }
}