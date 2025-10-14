package com.example.noteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.components.Buttoncom
import com.example.noteapp.components.InputField
import com.example.noteapp.model.NoteModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(note: List<NoteModel>,
               onNoteAdd:(NoteModel)->Unit,
               onNoteRemove:(NoteModel)->Unit){
    val title = remember {
        mutableStateOf("")
    }
    val description=remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = { Text(stringResource(id = R.string.app_name)) }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "noti")
        },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray))

    }
    Column(modifier = Modifier.fillMaxWidth().padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        InputField(text = title.value, label = "Title",  onTextChange = {
            if (it.all { char -> char.isLetter() || char.isWhitespace() }) title.value = it

        },
            onImeAction = {}
        )

        Spacer(modifier = Modifier.padding(6.dp))

        InputField(text = description.value, label = "Add Notes",  onTextChange = {
            if (it.all { char -> char.isLetter() || char.isWhitespace() })
                description.value = it

        },
            onImeAction = {}
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Buttoncom(text = "Save", onclick = {
            if(title.value.isNotEmpty() && description.value.isNotEmpty()){

                title.value=""
                description.value=""
            }
        })



    }



}










@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotePreview(){
    NoteScreen()

}