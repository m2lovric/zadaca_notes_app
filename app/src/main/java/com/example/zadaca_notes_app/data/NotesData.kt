package com.example.zadaca_notes_app.data

class NotesData {
    suspend fun getNotes(): List<Note> {
        return listOf(Note(1,"some note"))
    }
}