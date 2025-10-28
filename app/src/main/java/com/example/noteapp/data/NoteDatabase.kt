package com.example.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapp.Util.DateConverter
import com.example.noteapp.Util.UUIDconverter
import com.example.noteapp.model.NoteModel
import java.util.UUID

@Database(entities = [NoteModel::class],
    version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDconverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}