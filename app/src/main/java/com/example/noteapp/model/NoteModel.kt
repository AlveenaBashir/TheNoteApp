package com.example.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
import java.time.Instant


@Entity(tableName = "notes_tbl")
data class NoteModel(
    @PrimaryKey
    val id: UUID= UUID.randomUUID(),

    @ColumnInfo(name = "notes_title")
    val titles: String,
    @ColumnInfo(name = "notes_description")
    val descriptions:String,
    @ColumnInfo(name = "notes_entrydate")
    val entrydate: Date = Date.from(Instant.now())
)
