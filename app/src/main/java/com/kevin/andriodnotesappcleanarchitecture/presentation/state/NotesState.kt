package com.kevin.andriodnotesappcleanarchitecture.presentation.state

import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val message: String = ""
)