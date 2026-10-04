package com.slobodan.pmfapp.data.repository

import com.slobodan.pmfapp.data.dao.StudyProgramDao
import com.slobodan.pmfapp.data.model.enums.StudyPrograms
import com.slobodan.pmfapp.data.model.relation.StudyProgramWithDetailsWithSubjects

class StudyProgramRepository (private val studyProgramDao: StudyProgramDao) {
    suspend fun getStudyProgram(studyProgram: StudyPrograms): StudyProgramWithDetailsWithSubjects? {
        val database = studyProgram.dbName?: return null
        return studyProgramDao.getStudyProgramAll(database)
    }
}