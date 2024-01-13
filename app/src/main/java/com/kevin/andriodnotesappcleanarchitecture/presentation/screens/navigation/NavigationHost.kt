package com.kevin.andriodnotesappcleanarchitecture.presentation.screens.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kevin.andriodnotesappcleanarchitecture.presentation.screens.NotesListScreen
import com.kevin.andriodnotesappcleanarchitecture.presentation.screens.commons.BottomNavItem
import com.kevin.andriodnotesappcleanarchitecture.presentation.screens.components.AddNotesScreen

@Composable
fun NavigationHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController,
        startDestination = BottomNavItem.Notes.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(BottomNavItem.Notes.route) {
            NotesListScreen(hiltViewModel())
        }
        composable(BottomNavItem.AddNote.route) {
            AddNotesScreen(hiltViewModel())
        }
    }

}