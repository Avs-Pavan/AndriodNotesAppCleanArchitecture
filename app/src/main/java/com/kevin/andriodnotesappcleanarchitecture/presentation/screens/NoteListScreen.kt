package com.kevin.andriodnotesappcleanarchitecture.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note
import com.kevin.andriodnotesappcleanarchitecture.presentation.NotesViewModel
import com.kevin.andriodnotesappcleanarchitecture.presentation.screens.components.NotesListUI

@Composable
fun NotesListScreen(viewModel: NotesViewModel) {

    LaunchedEffect(true) {
        viewModel.addNotes(
            Note(
                0,
                "Title",
                "Content",
                System.currentTimeMillis(),
            )
        )
        viewModel.getAllNotes()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        NotesListUI(viewModel.state.value.notes)

        FloatingActionButton(
            onClick = {
                Log.e("Click", "Button clicked.")
            },
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    }
}