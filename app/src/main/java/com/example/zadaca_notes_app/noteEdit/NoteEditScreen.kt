package com.example.zadaca_notes_app.noteEdit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NoteEditScreen(viewModel: NotesEditModel,  navController: NavController, noteId: String ) {
    val notes by viewModel.notes.collectAsState()
    val currentNoteContent = notes.find { it.id == noteId.toInt() }.let { it!!.content }
    var noteText by remember { mutableStateOf(currentNoteContent) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Edit",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 24.dp)
                )
                Button(
                    onClick = { navController.navigate("notes_list") }
                ) {
                    Text("Go Back")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(72.dp)
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )  {
                TextField(
                    value = noteText,
                    onValueChange = {noteText = it},
                    modifier = Modifier.fillMaxWidth(0.65f)
                )

                Button(
                    onClick = {
                        viewModel.updateNote(noteId.toInt(), noteText)
                        navController.navigate("notes_list")
                    },
                    modifier = Modifier.fillMaxHeight(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors( Color(0xFF1abc9c))
                ) {
                    Text("Edit note")
                }
            }


        }
    }
}