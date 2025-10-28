package com.example.noteapp.Util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDconverter{
    @TypeConverter
    fun uuid(uid: UUID): String?{
        return uid.toString()

    }
    @TypeConverter
    fun uuidfromstring(string: String): UUID?{
        return UUID.fromString(string)

    }
}
