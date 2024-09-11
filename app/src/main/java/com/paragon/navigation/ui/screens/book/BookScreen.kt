package com.paragon.navigation.ui.screens.book

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun BookScreen(data: String?) {
    var textFieldState by rememberSaveable {
        mutableStateOf("")
    }
    LaunchedEffect(Unit) {
        if (data?.isNotEmpty() == true) {
            textFieldState = "Deep Link data :- $data"
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Book Screen")
        OutlinedTextField(placeholder = {
            Text(text = "Please Enter any value to see state")
        }, value = textFieldState, onValueChange = {
            textFieldState = it
        })
    }
}