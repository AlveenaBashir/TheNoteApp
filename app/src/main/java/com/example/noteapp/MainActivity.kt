package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.screens.NoteScreen
import com.example.noteapp.screens.NoteViewModel
import com.example.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                // val noteViewModel=viewModel<NoteViewModel>() this also works
                val noteViewModel: NoteViewModel by viewModels()
                NoteApp(noteViewModel)
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel){
    val notelist=noteViewModel.notelist.collectAsState().value
    NoteScreen(notes = notelist, onNoteAdd = {
        noteViewModel.addnote(it)
    }, onNoteRemove = {
        noteViewModel.removenote(it)
    })


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        NoteScreen(notes = emptyList(), onNoteAdd = {}, onNoteRemove = {})
    }
}