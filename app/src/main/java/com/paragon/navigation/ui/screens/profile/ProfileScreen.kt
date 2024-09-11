package com.paragon.navigation.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

sealed class ProfileScreenNavigation(val route: String) {
    data object Child1 : ProfileScreenNavigation("child_1")
    data object Child2 : ProfileScreenNavigation("child_2")
    data object Child3 : ProfileScreenNavigation("child_3")
    data object Child4 : ProfileScreenNavigation("child_4")
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val navController = rememberNavController()
        Column(modifier = Modifier.safeDrawingPadding()) {
            Text(modifier = Modifier.padding(top = 20.dp , start = 16.dp , bottom = 20.dp), style = MaterialTheme.typography.titleLarge, text = "Profile Screen as A Parent Screen")
            ChildrenNavHost(navController)
        }

    }
}