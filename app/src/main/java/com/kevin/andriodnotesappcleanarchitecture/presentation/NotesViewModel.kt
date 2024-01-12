package com.kevin.andriodnotesappcleanarchitecture.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevin.andriodnotesappcleanarchitecture.commons.exceptions.InvalidNoteException
import com.kevin.andriodnotesappcleanarchitecture.commons.mappers.toNote
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note
import com.kevin.andriodnotesappcleanarchitecture.domain.usecases.NotesUseCases
import com.kevin.andriodnotesappcleanarchitecture.presentation.state.NotesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val notesUseCases: NotesUseCases) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state


    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.e("NOtes::", "fetching")
            notesUseCases.getAllNotesUseCase().collect {
                Log.e("Notes::", it.joinToString())
                _state.value = _state.value.copy(
                    notes = it.map { noteEntity -> noteEntity.toNote() }
                )
            }
        }
    }

    fun addNotes(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                notesUseCases.addNoteUseCase(note)
                _state.value = _state.value.copy(
                    message = "Notes added successfully."
                )
            } catch (invalidNotesException: InvalidNoteException) {
                _state.value = _state.value.copy(
                    message = invalidNotesException.localizedMessage ?: "Error adding note."
                )
            }

        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            notesUseCases.deleteNoteUseCase(note)
            _state.value = _state.value.copy(
                message = "Notes deleted successfully."
            )
        }
    }
}