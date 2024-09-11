package com.paragon.navigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.paragon.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** "http://meenagopal24.live/route?route=home "*/
        val uri = intent.data
        val route = uri?.getQueryParameter("route")
        enableEdgeToEdge()
        setContent {
            var startDestination by remember { mutableStateOf(Screen.Home.route) }
            if (route?.isNotEmpty() == true) startDestination = route
            Log.e("TAG", "onCreateRouteIs: $startDestination", )
/*            val navController = rememberNavController()
            val currentRoute = remember { mutableStateOf(Screen.Home.route) }
            navController.addOnDestinationChangedListener { _, destination, _ ->
                currentRoute.value = destination.route.orEmpty()
            }*/
            NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(startDestination = startDestination)
                }
            }
        }
    }
}