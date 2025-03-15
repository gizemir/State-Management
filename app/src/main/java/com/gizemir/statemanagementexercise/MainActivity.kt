package com.gizemir.statemanagementexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gizemir.statemanagementexercise.ui.theme.StateManagementExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateManagementExerciseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    var kullaiciAdi = remember { mutableStateOf("kullanici adi") }
    var kullaiciEmail = remember { mutableStateOf("kullanici email") }
    Column(
        modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        OzelText(string = "hello")
        Spacer(modifier = Modifier.padding(10.dp))
        OzelText(string = "merhaba")
        Spacer(modifier = Modifier.padding(10.dp))
        OzelTextField(string= kullaiciAdi.value, onValueChangeFunction = {
            kullaiciAdi.value = it
        })
        OzelTextField(string= kullaiciEmail.value, onValueChangeFunction = {
            kullaiciEmail.value = it
        })
        Button(onClick = {

        }) {
            Text(text = "Kayit ol")
        }
    }
}
//STATELESS
//bu composable sayesinde buton içinde de texfield'in değişkenlerine ulaşabileceğiz
@Composable
fun OzelTextField(string: String, onValueChangeFunction: (String) -> Unit){
    TextField(value = string, onValueChange = onValueChangeFunction, modifier = Modifier.padding(10.dp))
}

@Composable
fun OzelText(string: String){
    Text(text = string,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateManagementExerciseTheme {
        MainScreen()
    }
}

