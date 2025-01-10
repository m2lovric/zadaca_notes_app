package com.example.zadaca_notes_app.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NoteRepository {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    private val notes: StateFlow<List<Note>> = _notes

    private var id = 1

    fun getNotes(): StateFlow<List<Note>> = notes

    fun updateNote(id:Int, content: String) {
        _notes.value.find { it -> it.id == id }?.content = content
    }

    fun addNote(content: String) {
        _notes.value += Note(id++, content)
    }

    fun deleteNote(id: Int) {
        _notes.value = _notes.value.filter { it.id != id }
    }
}

