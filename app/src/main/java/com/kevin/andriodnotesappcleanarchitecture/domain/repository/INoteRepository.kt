package com.kevin.andriodnotesappcleanarchitecture.domain.repository

import com.kevin.andriodnotesappcleanarchitecture.data.localdatasource.NoteEntity
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface INoteRepository {
    fun getNotes(): Flow<List<NoteEntity>>
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
}