package com.kevin.andriodnotesappcleanarchitecture.presentation.screens.components

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kevin.andriodnotesappcleanarchitecture.domain.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListUI(
    notes: List<Note>,
    onDeleteNote: (note: Note) -> Unit
) {
    LazyColumn {
        items(
            items = notes,
            key = {
                it.id
            }) { note ->


            val dismissState = rememberDismissState()

            if (dismissState.isDismissed(direction = DismissDirection.EndToStart)) {
                onDeleteNote(note)
            }
            SwipeToDismiss(
                state = dismissState,
                directions = setOf(
                    DismissDirection.EndToStart
                ),
                background = {
                    // background color
                    val backgroundColor by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.DismissedToStart -> Color.Red.copy(alpha = 0.8f)
                            else -> Color.White
                        }, label = ""
                    )

                    // icon
                    val iconImageVector = Icons.Outlined.Delete

                    // icon placement
                    val iconAlignment = Alignment.CenterEnd

                    // icon size
                    val iconScale by animateFloatAsState(
                        targetValue = if (dismissState.targetValue == DismissValue.Default) 0.5f else 1.3f,
                        label = ""
                    )

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color = backgroundColor)
                            .padding(start = 16.dp, end = 16.dp), // inner padding
                        contentAlignment = iconAlignment
                    ) {
                        Icon(
                            modifier = Modifier.scale(iconScale),
                            imageVector = iconImageVector,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                dismissContent = {
                    NoteCard(note) {
                        onDeleteNote(note)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            )

        }
    }
}