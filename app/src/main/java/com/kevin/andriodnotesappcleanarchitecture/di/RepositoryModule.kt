package com.kevin.andriodnotesappcleanarchitecture.di

import com.kevin.andriodnotesappcleanarchitecture.data.repository.NoteRepository
import com.kevin.andriodnotesappcleanarchitecture.domain.repository.INoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provide(noteRepository: NoteRepository): INoteRepository
}