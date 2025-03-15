package com.gizemir.statemanagementexercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gizemir.statemanagementexercise.ui.theme.StateManagementExerciseTheme

@Composable
fun Examples(){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        var userNote = remember { mutableStateOf("") }

        //KULLANICIDAN ALINAN TEXT
        TextField(value = userNote.value, onValueChange = {
            userNote.value = it
        }, placeholder = {
            Text("enter your note")
        })

        var textValue = remember { mutableStateOf("Butona tıklanmadan önce") }
        Spacer(modifier = Modifier.padding(10.dp))
        //TEXT
        Text(text=textValue.value)
        Spacer(modifier = Modifier.padding(10.dp))

        //BUTTON
        Button(onClick = {
            textValue.value = "Butona tıklandığında text değişti"
        }, enabled = true) {
            Text(text = "Click Me")
        }

        var paddingValue = remember { mutableStateOf(10.dp) }
        Spacer(modifier = Modifier.padding(paddingValue.value))

        //IMAGE
        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.tokyo),
            contentDescription = "Tokyo Image",
            modifier = Modifier.size(350.dp, 220.dp)
        )

        Spacer(modifier = Modifier.padding(10.dp))
        //IMAGE
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Launcher Image",
        )
        //IMAGE
        Spacer(modifier = Modifier.padding(10.dp))

        Image(painter = ColorPainter(Color.Blue),
            contentDescription = "Blue Image",
            modifier = Modifier.size(150.dp, 220.dp))
    }
}
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateManagementExerciseTheme {
        Examples()
    }
} */