package com.kevin.andriodnotesappcleanarchitecture.presentation.screens.commons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Notes : BottomNavItem("notes", Icons.Default.List, "Notes")
    object AddNote : BottomNavItem("add_note", Icons.Default.Add, "Add note")
    companion object {
        fun values(): List<BottomNavItem> {
            return listOf(Notes, AddNote)
        }
    }
}