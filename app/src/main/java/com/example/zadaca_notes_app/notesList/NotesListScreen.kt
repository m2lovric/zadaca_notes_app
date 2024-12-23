package com.example.zadaca_notes_app.notesList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotesListScreen(viewModel: NotesViewModel) {
    val notes by viewModel.notes.collectAsState()
    Scaffold() { contentPadding ->
        Column {
            Text("Notes", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            LazyColumn(modifier = Modifier.fillMaxSize().padding(contentPadding)) {
                items(notes) {note ->
                    Text(
                        text = note.content,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}