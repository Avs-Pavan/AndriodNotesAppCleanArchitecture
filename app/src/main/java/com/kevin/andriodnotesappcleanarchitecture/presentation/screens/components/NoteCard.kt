package com.kevin.andriodnotesappcleanarchitecture.presentation.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note

@Composable
fun NoteCard(note: Note, deleteNote: () -> Unit) {
    Column(
        modifier = Modifier
            .background(color = Color.Cyan, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { deleteNote() }
    ) {
        Text(text = note.title)
        Text(text = note.content)
        Text(text = note.timeStampToDisplay ?: "")
    }
}