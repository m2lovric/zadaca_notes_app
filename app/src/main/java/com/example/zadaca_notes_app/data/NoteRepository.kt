package com.example.zadaca_notes_app.data

class NoteRepository(private val notesData: NotesData) {
    private var _notes: List<Note>? = null

    suspend fun getNotes(): Result<List<Note>>  {
        val currentNotes = _notes
        currentNotes?.let {
            return Result.success(it)
        }

        return try {
            val newNotes = notesData.getNotes()
            _notes = newNotes
            Result.success(newNotes)
        } catch (ex : Exception) {
            Result.failure(ex)
        }
    }
}

