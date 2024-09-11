package com.paragon.navigation.ui.screens.demoScreen.fourth

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun FourthScreen(onBackPressed: (String?) -> Unit = {}, openFirstWhileDestroyingCurrentScreen : (String?) -> Unit = {} ,data: String?) {
    var textFieldState by rememberSaveable {
        mutableStateOf("")
    }
    var sendDataBack by rememberSaveable {
        mutableStateOf("")
    }
    BackHandler {
        onBackPressed(sendDataBack)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Fourth Screen")
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

        Button(onClick = { openFirstWhileDestroyingCurrentScreen(null) } ){
            Text(text = "Jump Back To First Screen and Destroy Current Screen")
        }
        Button(onClick = { openFirstWhileDestroyingCurrentScreen(textFieldState) }) {
            Text(text = "Jump Back with Text Data First Screen and Destroy Current Screen")
        }
    }
}