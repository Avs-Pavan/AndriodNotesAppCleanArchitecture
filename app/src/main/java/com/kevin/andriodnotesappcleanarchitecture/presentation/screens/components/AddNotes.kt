package com.kevin.andriodnotesappcleanarchitecture.presentation.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun AddNotesUI(saveNotes: (String, String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Title") }
        )
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text(text = "Content") }
        )
        Button(onClick = {
            saveNotes(title, content)
        }) {
            Text(text = "Save note")
        }
    }
}