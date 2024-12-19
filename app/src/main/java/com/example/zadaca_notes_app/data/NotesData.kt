package com.example.zadaca_notes_app.data

class NotesData {
    suspend fun getNotes(): List<Note> {
        return listOf(Note("some note"))
    }
}