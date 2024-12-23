package com.example.zadaca_notes_app.notesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.zadaca_notes_app.data.Note
import com.example.zadaca_notes_app.data.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotesViewModel(private val repository: NoteRepository): ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    init {
        loadNotes()
    }

    private fun loadNotes() {
        _notes.value = repository.getNotes()
    }

    fun addNote(content: String) {
        if(content.isNotBlank()){
            repository.addNote(content)
        }
    }

    fun deleteNote(id: Int) {
        repository.deleteNote(id)
        loadNotes()
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