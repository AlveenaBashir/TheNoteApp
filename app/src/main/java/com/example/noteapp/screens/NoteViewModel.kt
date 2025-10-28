package com.example.noteapp.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.model.NoteModel
import com.example.noteapp.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {

   private val _notelist= MutableStateFlow<List<NoteModel>>(emptyList())
    val notelist=_notelist.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getallnotes().distinctUntilChanged()
                .collect{listofnotes->
                    if (listofnotes.isNullOrEmpty()){
                        Log.d("empty", ": empty list")
                    }else{
                        _notelist.value=listofnotes
                    }

                }
        }
       // notelist.addAll(NoteDataSource().loadnotes())
    }
    fun addnote(note: NoteModel)= viewModelScope.launch { repository.addnotes(note) }
    fun removenote(note: NoteModel)=viewModelScope.launch { repository.deletenotes(note) }
    fun updatenote(note: NoteModel)=viewModelScope.launch { repository.updatenotes(note) }


}