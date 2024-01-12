package com.kevin.andriodnotesappcleanarchitecture.commons.mappers

import com.kevin.andriodnotesappcleanarchitecture.data.localdatasource.NoteEntity
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun NoteEntity.toNote(): Note {
    return Note(
        id = id ?: 0,
        title = title,
        content = content,
        timeStamp = timeStamp,
        timeStampToDisplay = timeStamp.toDate()
    )
}


fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        content = content,
        timeStamp = timeStamp
    )
}


fun Long.toDate(): String {
    val date = Date(this)
    val format =
        SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
    return format.format(date)
}