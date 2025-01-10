package com.example.zadaca_notes_app.noteEdit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.zadaca_notes_app.data.Note
import com.example.zadaca_notes_app.data.NoteRepository
import com.example.zadaca_notes_app.notesList.NotesViewModel
import kotlinx.coroutines.flow.StateFlow

class NotesEditModel(private val repository: NoteRepository): ViewModel() {
    val notes: StateFlow<List<Note>> = repository.getNotes()

    fun updateNote(id: Int, content: String) {
        repository.updateNote(id, content)
    }

    companion object {
        val Factory = NotesViewModel.Factory
    }
}