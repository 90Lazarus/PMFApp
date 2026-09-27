package com.slobodan.pmfapp.data.repository

import com.slobodan.pmfapp.data.dao.SubjectDao
import com.slobodan.pmfapp.data.entity.SubjectEntity

class SubjectRepository (private val subjectDao: SubjectDao) {
    suspend fun getSubjectsForStudyProgram(studyProgramId: Int): List<SubjectEntity> {
        return subjectDao.getSubjectsForStudyProgram(studyProgramId)
    }

    suspend fun getSubjectsForStudyAndSemester(studyProgramId: Int, semester: Int) {

    }

    suspend fun getSubjectDetails(subjectId: Int): SubjectEntity {
        return subjectDao.getSubjectWithDetails(subjectId)
    }
}