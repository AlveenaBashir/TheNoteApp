package com.example.noteapp.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.R
import com.example.noteapp.Util.formatdate
import com.example.noteapp.components.Buttoncom
import com.example.noteapp.components.InputField
import com.example.noteapp.data.NoteDataSource
import com.example.noteapp.model.NoteModel
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(notes: List<NoteModel>,
               onNoteAdd:(NoteModel)->Unit,
               onNoteRemove:(NoteModel)->Unit){
    val title = remember {
        mutableStateOf("")
    }
    val description=remember { mutableStateOf("") }
    val context= LocalContext.current
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
                onNoteAdd(NoteModel(titles = title.value, descriptions = description.value))

                title.value=""
                description.value=""
                Toast.makeText(context,"Note Added", Toast.LENGTH_SHORT)
            }
        })
        Spacer(modifier = Modifier.padding(6.dp))

        HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.padding(6.dp))
        LazyColumn(modifier = Modifier.padding(start = 12.dp).fillMaxWidth()     // makes the column take full width
            , horizontalAlignment = Alignment.Start){
            items(notes){ noteit->
                Noterow(note=noteit, onclicked = {onNoteRemove(noteit)})


            }
        }





    }



}

@Composable
fun Noterow(modifier: Modifier= Modifier,
            note: NoteModel,
            onclicked:(NoteModel)-> Unit){
    Surface(modifier.padding(5.dp).clip(shape = RoundedCornerShape(12.dp))
        .fillMaxWidth(),
        color = Color.LightGray,
        shadowElevation = 5.dp
        ){
        Column(modifier
            .clickable{
                onclicked(note)


        }.padding(horizontal = 15.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.titles, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = note.descriptions, style = MaterialTheme.typography.titleMedium)
            Text(text = formatdate(note.entrydate.time), style = MaterialTheme.typography.bodySmall)



        }
    }

}








@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotePreview(){
    NoteScreen(notes = NoteDataSource().loadnotes(), onNoteAdd = {}, onNoteRemove = {})

}