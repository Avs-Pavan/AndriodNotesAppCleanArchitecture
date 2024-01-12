package com.kevin.andriodnotesappcleanarchitecture.domain.usecases

import com.kevin.andriodnotesappcleanarchitecture.commons.exceptions.InvalidNoteException
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note
import com.kevin.andriodnotesappcleanarchitecture.domain.repository.INoteRepository

class AddNoteUseCase(private val noteRepository: INoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isEmpty())
            throw InvalidNoteException("Note title cannot be empty.")
        if (note.content.isEmpty())
            throw InvalidNoteException("Note content cannot be empty.")
        noteRepository.addNote(note)
    }
}