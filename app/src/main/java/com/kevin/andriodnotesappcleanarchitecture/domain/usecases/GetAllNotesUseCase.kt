package com.kevin.andriodnotesappcleanarchitecture.domain.usecases

import com.kevin.andriodnotesappcleanarchitecture.data.localdatasource.NoteEntity
import com.kevin.andriodnotesappcleanarchitecture.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(private val noteRepository: INoteRepository) {

    operator fun invoke(): Flow<List<NoteEntity>> {
        return noteRepository.getNotes()
    }

}