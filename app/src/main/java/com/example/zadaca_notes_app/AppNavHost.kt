package com.example.zadaca_notes_app

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zadaca_notes_app.noteEdit.NoteEditScreen
import com.example.zadaca_notes_app.noteEdit.NotesEditModel
import com.example.zadaca_notes_app.notesList.NotesListScreen
import com.example.zadaca_notes_app.notesList.NotesViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    val viewModel: NotesViewModel = viewModel(factory = NotesViewModel.Factory)
    val viewEdit: NotesEditModel = viewModel(factory = NotesEditModel.Factory)
    NavHost(
        navController = navController,
        startDestination = "notes_list"
    ) {
        composable("notes_list") {
            NotesListScreen(viewModel, navController)
        }
        composable("note_edit/{noteId}") { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")
            if (noteId != null) {
                NoteEditScreen(viewEdit, navController, noteId)
            }
        }
    }
}