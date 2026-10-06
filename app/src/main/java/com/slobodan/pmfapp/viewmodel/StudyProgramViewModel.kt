package com.slobodan.pmfapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.slobodan.pmfapp.PMFApplication
import com.slobodan.pmfapp.data.model.relation.StudyProgramWithDetailsWithSubjects
import com.slobodan.pmfapp.data.model.enums.StudyPrograms
import com.slobodan.pmfapp.data.repository.StudyProgramRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StudyProgramViewModel (
    private val studyProgramRepository: StudyProgramRepository
    ) : ViewModel() {
    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application: PMFApplication = this[APPLICATION_KEY] as PMFApplication
                val studyProgramRepository = application.studyProgramRepository
                StudyProgramViewModel(studyProgramRepository = studyProgramRepository)
            }
        }
    }
    private val _studyProgram = MutableStateFlow<StudyProgramWithDetailsWithSubjects?>(null)
    val studyProgram = _studyProgram.asStateFlow()
    fun loadStudyProgram(program: StudyPrograms) {
        viewModelScope.launch {
            _studyProgram.value = studyProgramRepository.getStudyProgram(program)
        }
    }
}