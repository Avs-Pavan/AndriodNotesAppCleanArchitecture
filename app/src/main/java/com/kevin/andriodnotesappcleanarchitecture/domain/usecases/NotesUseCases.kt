package com.kevin.andriodnotesappcleanarchitecture.domain.usecases

data class NotesUseCases(
    val addNoteUseCase: AddNoteUseCase,
    val getAllNotesUseCase: GetAllNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)