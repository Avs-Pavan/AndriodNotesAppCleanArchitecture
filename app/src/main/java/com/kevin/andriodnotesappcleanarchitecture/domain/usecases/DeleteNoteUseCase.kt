package com.kevin.andriodnotesappcleanarchitecture.domain.usecases

import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note
import com.kevin.andriodnotesappcleanarchitecture.domain.repository.INoteRepository

class DeleteNoteUseCase(private val noteRepository: INoteRepository) {
    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}