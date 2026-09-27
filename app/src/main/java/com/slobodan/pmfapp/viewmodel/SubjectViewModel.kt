package com.slobodan.pmfapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.slobodan.pmfapp.PMFApplication
import com.slobodan.pmfapp.data.repository.SubjectRepository

class SubjectViewModel (
    private val subjectRepository: SubjectRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application: PMFApplication = this[APPLICATION_KEY] as PMFApplication
                val savedStateHandle = createSavedStateHandle()
                val subjectRepository = application.subjectRepository
                SubjectViewModel(
                    subjectRepository = subjectRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }
}