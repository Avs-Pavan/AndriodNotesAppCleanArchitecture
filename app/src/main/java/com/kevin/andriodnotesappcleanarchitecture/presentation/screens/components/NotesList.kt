package com.kevin.andriodnotesappcleanarchitecture.presentation.screens.components

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note

@Composable
fun NotesListUI(notes: List<Note>) {
    LazyColumn {
        items(notes) { note ->
            Log.e("Note--", note.toString())
            NoteCard(note)
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}