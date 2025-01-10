package com.example.zadaca_notes_app.notesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.zadaca_notes_app.data.Note
import com.example.zadaca_notes_app.data.NoteRepository
import kotlinx.coroutines.flow.StateFlow

class NotesViewModel(private val repository: NoteRepository): ViewModel() {
    val notes: StateFlow<List<Note>> = repository.getNotes()

    fun addNote(content: String) {
        if(content.isNotBlank()){
            repository.addNote(content)
        }
    }

    fun updateNote(id: Int, content: String) {
        repository.updateNote(id, content)
    }

    fun deleteNote(id: Int) {
        repository.deleteNote(id)
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val repository = NoteRepository()
                NotesViewModel(repository)
            }
        }
    }
}