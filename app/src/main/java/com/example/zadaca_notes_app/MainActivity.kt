package com.example.zadaca_notes_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.zadaca_notes_app.notesList.NotesListScreen
import com.example.zadaca_notes_app.notesList.NotesViewModel
import com.example.zadaca_notes_app.ui.theme.Zadaca_Notes_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: NotesViewModel = ViewModelProvider(this, NotesViewModel.Factory)[NotesViewModel::class.java]
            Zadaca_Notes_AppTheme {
                NotesListScreen(viewModel)
            }
        }
    }
}