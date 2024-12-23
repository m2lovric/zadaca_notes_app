package com.example.zadaca_notes_app.data

class NoteRepository {
    private val notes = mutableListOf<Note>(Note(123123, "First note"))
    private var id = 1

    fun getNotes(): List<Note> = notes

    fun updateNote(id:Int, content: String) {
        notes.find { it -> it.id == id }?.content = content
    }

    fun addNote(content: String) {
        notes.add(Note(id++, content))
    }

    fun deleteNote(id: Int) {
        notes.removeAll{ it -> it.id == id}
    }
}

