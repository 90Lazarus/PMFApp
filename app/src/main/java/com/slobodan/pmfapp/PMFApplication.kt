package com.slobodan.pmfapp

import android.app.Application
import com.slobodan.pmfapp.data.database.PMFAppDatabase
import com.slobodan.pmfapp.data.repository.StudyProgramRepository
import com.slobodan.pmfapp.data.repository.SubjectRepository

class PMFApplication : Application() {
    val database by lazy {
        PMFAppDatabase.getDatabase(this)
    }
    val studyProgramRepository by lazy {
        StudyProgramRepository(database.studyProgramDao())
    }

    val subjectRepository by lazy {
        SubjectRepository(database.subjectDao())
    }
}