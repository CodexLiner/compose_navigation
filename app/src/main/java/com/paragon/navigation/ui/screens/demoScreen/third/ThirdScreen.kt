package com.paragon.navigation.ui.screens.demoScreen.third

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
fun ThirdScreen( onBackPressed: (String?) -> Unit, openFourthScreen: (String?) -> Unit, data: String?, backPressedData: String?) {
    var textFieldState by rememberSaveable {
        mutableStateOf("")
    }
    var sendDataBack by rememberSaveable {
        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        textFieldState = data ?: "No Data Received"
        sendDataBack = backPressedData ?: "No Data Received"
    }
    BackHandler {
        onBackPressed(sendDataBack)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onError),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Third Screen")
        OutlinedTextField(placeholder = {
            Text(text = "Please Enter any value to see state")
        }, value = textFieldState, onValueChange = {
            textFieldState = it
        })

        OutlinedTextField(placeholder = {
            Text(text = "Enter Data Here Before Back Press")
        }, value = sendDataBack, onValueChange = {
            sendDataBack = it
        })
        Button(onClick = { openFourthScreen(null) }) {
            Text(text = "Open Fourth Screen ")
        }
        Button(onClick = { openFourthScreen(textFieldState) }) {
            Text(text = "Open with Text Data Fourth Screen ")
        }
    }

}