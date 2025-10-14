package com.example.noteapp.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Buttoncom(
    modifier: Modifier= Modifier,
    enabled: Boolean=true,
    text: String,
    onclick:()->Unit,

    ){
    Button(onClick = onclick,
        shape = RoundedCornerShape(12.dp),
        enabled = enabled,
        modifier = modifier,

    ) {
        Text(text = text)
    }

}