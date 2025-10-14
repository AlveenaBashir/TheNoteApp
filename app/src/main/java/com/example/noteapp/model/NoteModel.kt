package com.example.noteapp.model

import java.time.LocalDateTime
import java.util.UUID

data class NoteModel(
    val id: UUID= UUID.randomUUID(),
    val titles: String,
    val descriptions:String,
    val entrydate: LocalDateTime= LocalDateTime.now()
)
