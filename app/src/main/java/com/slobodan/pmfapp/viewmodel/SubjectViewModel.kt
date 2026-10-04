package com.slobodan.pmfapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.slobodan.pmfapp.PMFApplication
import com.slobodan.pmfapp.data.model.relation.SubjectWithDetails
import com.slobodan.pmfapp.data.repository.SubjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SubjectViewModel (
    private val subjectRepository: SubjectRepository,
) : ViewModel() {
    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application: PMFApplication = this[APPLICATION_KEY] as PMFApplication
                val subjectRepository = application.subjectRepository
                SubjectViewModel(subjectRepository = subjectRepository)
            }
        }
    }
    private val _subject = MutableStateFlow<SubjectWithDetails?>(null)
    val subject = _subject.asStateFlow()
    fun loadSubjectById(id: Int) {
        viewModelScope.launch {
            _subject.value = subjectRepository.getSubjectDetails(id)
        }
    }
    fun getSubjectIdByName(name: String, studyProgramId: Int, onResult: (Int?) -> Unit) {
        viewModelScope.launch {
            val subjectId = subjectRepository.getSubjectIdByName(name, studyProgramId)
            onResult(subjectId)
        }
    }
}