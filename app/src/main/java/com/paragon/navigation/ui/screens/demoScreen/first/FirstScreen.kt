package com.paragon.navigation.ui.screens.demoScreen.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FirstScreen(openSecondScreen: (String?) -> Unit = {}, data: String?, backPressedData: String?) {
    var textFieldState by rememberSaveable {
        mutableStateOf("")
    }
    var sendDataBack by rememberSaveable {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        textFieldState = data ?: "No Data Received"
    }
    LaunchedEffect(backPressedData) {
        sendDataBack = backPressedData ?: "No Data Received"
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Screen")
        OutlinedTextField(placeholder = {
            Text(text = "Please Enter any value to see state")
        }, value = textFieldState, onValueChange = {
            textFieldState = it
        })

        OutlinedTextField(placeholder = {
            Text(text = "Here Data from back Pressed will be shown")
        }, value = sendDataBack, onValueChange = {
            sendDataBack = it
        })

        Button(onClick = { openSecondScreen(null) } ){
            Text(text = "Open Second Screen ")
        }
        Button(onClick = { openSecondScreen(textFieldState) }) {
            Text(text = "Open with Text Data Second Screen ")
        }
    }
}