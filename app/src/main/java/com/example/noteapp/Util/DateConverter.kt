package com.example.noteapp.Util

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timestampfromdate(date: Date):Long{
        return date.time
    }
    @TypeConverter
    fun datefromtimestamp(timestamp: Long):Date?{
return Date(timestamp)
    }
}