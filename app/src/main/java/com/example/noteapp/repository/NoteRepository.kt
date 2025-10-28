package com.example.noteapp.repository

import com.example.noteapp.data.NoteDatabaseDao
import com.example.noteapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addnotes(note: NoteModel)=noteDatabaseDao.insert(note)
    suspend fun updatenotes(note: NoteModel)=noteDatabaseDao.update(note)
    suspend fun deletenotes(note: NoteModel)=noteDatabaseDao.deletenote(note)
    suspend fun deleteallnotes()=noteDatabaseDao.deleteall()
    suspend fun getallnotes()=noteDatabaseDao.getnotes().flowOn(Dispatchers.IO).conflate()



}