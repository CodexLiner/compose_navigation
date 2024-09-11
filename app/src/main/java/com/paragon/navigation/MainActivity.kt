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
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.paragon.navigation.ui.MainScreen
import com.paragon.navigation.ui.Screen
import com.paragon.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * please use this url pattern for testing this is not verified url so
         * you need to forcefully so for that from app info goto open by default and select http://meenagopal24.live and add
         * ["http://meenagopal24.live/route?route=home"]
         * ["http://meenagopal24.live/route?route=profile"]
         * ["http://meenagopal24.live/route?route=book"]
         *
         * for deep link with data this please open this url
         *
         * http://meenagopal24.live/route?route=book&data=Hello%20Honey%20Bunny
         *
         * this will open book screen with data
         *
         */

        enableEdgeToEdge()
        setContent {
            val startDestination by remember { mutableStateOf(Screen.Home.route) }
            Log.e("TAG", "onCreateRouteIs: $startDestination", )
            val navController = rememberNavController()
            NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(navController = navController, startDestination = startDestination)
                }
            }
        }
    }
}