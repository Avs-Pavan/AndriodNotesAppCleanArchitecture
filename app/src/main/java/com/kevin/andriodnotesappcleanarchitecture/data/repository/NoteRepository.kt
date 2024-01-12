package com.kevin.andriodnotesappcleanarchitecture.data.repository

import com.kevin.andriodnotesappcleanarchitecture.commons.mappers.toNoteEntity
import com.kevin.andriodnotesappcleanarchitecture.data.localdatasource.NoteDao
import com.kevin.andriodnotesappcleanarchitecture.data.localdatasource.NoteEntity
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note
import com.kevin.andriodnotesappcleanarchitecture.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) : INoteRepository {
    override fun getNotes(): Flow<List<NoteEntity>> = noteDao.getNotes()

    override suspend fun addNote(note: Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

}