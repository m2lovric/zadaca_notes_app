package com.example.zadaca_notes_app.notesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.zadaca_notes_app.App
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

    fun deleteNote(id: Int) {
        repository.deleteNote(id)
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as App
                val repository = app.repositoryContainer.noteRepository
                NotesViewModel(repository)
            }
        }
    }
}