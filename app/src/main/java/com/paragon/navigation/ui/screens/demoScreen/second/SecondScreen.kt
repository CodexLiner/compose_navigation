package com.paragon.navigation.ui.screens.demoScreen.second

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
fun SecondScreen(
    onBackPressed: (String?) -> Unit,
    openThirdScreen: (String?) -> Unit = {},
    data: String?,
    backPressedData: String?
) {
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
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.inversePrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Screen")
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

        Button(onClick = { openThirdScreen(null) }) {
            Text(text = "Open Third Screen ")
        }
        Button(onClick = { openThirdScreen(textFieldState) }) {
            Text(text = "Open with Text Data Third Screen ")
        }
    }
}