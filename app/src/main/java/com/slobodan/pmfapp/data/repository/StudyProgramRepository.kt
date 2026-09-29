package com.slobodan.pmfapp.data.repository

import com.slobodan.pmfapp.data.dao.StudyProgramDao
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.model.StudyProgramWithDetails
import com.slobodan.pmfapp.data.model.StudyProgramWithDetailsWithSubjects
import com.slobodan.pmfapp.data.model.StudyProgramWithSubjects
import com.slobodan.pmfapp.data.model.StudyPrograms

class StudyProgramRepository (private val studyProgramDao: StudyProgramDao) {
    suspend fun getStudyProgramsByDegreeIdAndDepartmentId(degreeLevelId: Int, departmentId: Int): List<StudyProgramWithDetails> {
        return studyProgramDao.getStudyProgramsWithDetails(degreeLevelId, departmentId)
    }

    suspend fun getStudyProgramByIdWithSubjects(studyProgramId: Int) : StudyProgramWithSubjects {
        return studyProgramDao.getStudyProgramWithSubjects(studyProgramId)
    }

    suspend fun getStudyProgramByEnum(studyProgram: StudyPrograms): StudyProgramEntity? {
        val database = studyProgram.dbName?: return null
        return studyProgramDao.getStudyProgramByName(database)
    }

    suspend fun getStudyProgramByEnum2(studyProgram: StudyPrograms): StudyProgramWithDetailsWithSubjects? {
        val database = studyProgram.dbName?: return null
        return studyProgramDao.getStudyProgramAll(database)
    }
}