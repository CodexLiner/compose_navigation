package com.paragon.navigation.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun ProfileChildren_1(open: () -> Unit) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(
               Color.Green
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile Screen 1")

        Button(onClick = { open() }) {
            Text(text = "Open Next ")
        }
    }
}


@Composable
fun ProfileChildren_2(open: () -> Unit) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onError),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile Screen 2")

        Button(onClick = { open() }) {
            Text(text = "Open Next ")
        }
    }
}

@Composable
fun ProfileChildren_3(open: () -> Unit) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(
               Color.Cyan
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile Screen 3")

        Button(onClick = { open() }) {
            Text(text = "Open Next ")
        }
    }
}


@Composable
fun ProfileChildren_4() {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(
               Color.Yellow
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile Screen 4")

        Button(enabled = false, onClick = { }) {
            Text(text = "That's It Now Press Back")
        }
    }
}

