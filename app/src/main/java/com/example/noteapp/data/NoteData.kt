package com.example.noteapp.data

import com.example.noteapp.model.NoteModel

class NoteDataSource{
    fun loadnotes(): List<NoteModel>{
        return listOf(
            NoteModel(
                titles = "Grocery Shopping",
                descriptions = "Buy milk, bread, and eggs from the nearby store."
            ),
            NoteModel(
                titles = "Android Study",
                descriptions = "Revise Jetpack Compose basics and learn about ViewModel usage."
            ),
            NoteModel(
                titles = "Workout Plan",
                descriptions = "Do 20 minutes of cardio and full-body stretching."
            ),
            NoteModel(
                titles = "Meeting Notes",
                descriptions = "Prepare slides for the weekly project update meeting."
            ),
            NoteModel(
                titles = "Book Reading",
                descriptions = "Read 'Atomic Habits' for 30 minutes before bed."
            )
        )
    }
}