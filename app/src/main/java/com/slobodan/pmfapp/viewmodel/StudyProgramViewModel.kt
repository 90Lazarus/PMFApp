package com.slobodan.pmfapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.slobodan.pmfapp.PMFApplication
import com.slobodan.pmfapp.data.repository.StudyProgramRepository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import com.slobodan.pmfapp.data.entity.StudyProgramEntity
import com.slobodan.pmfapp.data.model.StudyPrograms
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StudyProgramViewModel (
    private val studyProgramRepository: StudyProgramRepository,
    private val savedStateHandle: SavedStateHandle
    ) : ViewModel() {
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application: PMFApplication = this[APPLICATION_KEY] as PMFApplication
                val savedStateHandle = createSavedStateHandle()
                val studyProgramRepository = application.studyProgramRepository
                StudyProgramViewModel(
                    studyProgramRepository = studyProgramRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }
    //UI state
    private val _studyProgram = MutableStateFlow<StudyProgramEntity?>(null)
    val studyProgram = _studyProgram.asStateFlow()
    //Actions the screen can call
    fun loadStudyProgram(program: StudyPrograms) {
        viewModelScope.launch {
            _studyProgram.value = studyProgramRepository.getStudyProgramByEnum(program)
        }
    }
}