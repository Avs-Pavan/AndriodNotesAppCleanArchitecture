package com.kevin.andriodnotesappcleanarchitecture.di

import android.app.Application
import androidx.room.Room
import com.kevin.andriodnotesappcleanarchitecture.commons.Constants
import com.kevin.andriodnotesappcleanarchitecture.data.localdatasource.NoteDao
import com.kevin.andriodnotesappcleanarchitecture.data.localdatasource.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataBase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            Constants.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDataBase: NoteDataBase): NoteDao {
        return noteDataBase.noteDao
    }

}