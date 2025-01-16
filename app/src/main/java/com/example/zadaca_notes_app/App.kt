package com.example.zadaca_notes_app

import android.app.Application
import android.app.Activity
import com.example.zadaca_notes_app.data.NoteRepository

class App: Application() {
    val repositoryContainer by lazy { RepositoryContainer }

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

object RepositoryContainer {
    val noteRepository: NoteRepository by lazy { NoteRepository() }
}

