package com.slobodan.pmfapp.data.repository

import com.slobodan.pmfapp.data.dao.SubjectDao
import com.slobodan.pmfapp.data.model.relation.SubjectWithDetails

class SubjectRepository (private val subjectDao: SubjectDao) {
    suspend fun getSubjectDetails(subjectId: Int): SubjectWithDetails {
        return subjectDao.getSubjectByIdWithDetails(subjectId)
    }

    suspend fun getSubjectIdByName(name: String, studyProgramId: Int): Int? {
        return subjectDao.getSubjectIdByName(name, studyProgramId)
    }
}