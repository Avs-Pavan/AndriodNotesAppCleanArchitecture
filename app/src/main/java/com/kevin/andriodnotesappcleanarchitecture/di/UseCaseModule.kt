package com.kevin.andriodnotesappcleanarchitecture.di

import com.kevin.andriodnotesappcleanarchitecture.data.repository.NoteRepository
import com.kevin.andriodnotesappcleanarchitecture.domain.usecases.AddNoteUseCase
import com.kevin.andriodnotesappcleanarchitecture.domain.usecases.DeleteNoteUseCase
import com.kevin.andriodnotesappcleanarchitecture.domain.usecases.GetAllNotesUseCase
import com.kevin.andriodnotesappcleanarchitecture.domain.usecases.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: NoteRepository): NotesUseCases {
        return NotesUseCases(
            getAllNotesUseCase = GetAllNotesUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository)
        )
    }
}