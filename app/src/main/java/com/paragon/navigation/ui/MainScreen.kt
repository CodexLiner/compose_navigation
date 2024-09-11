package com.paragon.navigation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.paragon.navigation.ui.navigation.Navigation

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Filled.Home)
    data object Profile : Screen("profile", "Profile", Icons.Filled.Person)
    data object Book : Screen("book?data={data}", "Book", Icons.Filled.DateRange)
    data object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
}

@Composable
fun MainScreen(startDestination: String , navController : NavHostController= rememberNavController()) {
    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navController)
    }) { innerPadding ->
        Navigation(navController = navController , startDestination)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home, Screen.Book, Screen.Profile, Screen.Settings
    )
    var currentSelectedItem by rememberSaveable { mutableStateOf<String?>(Screen.Home.route) }

    NavigationBar {
        navController.currentBackStackEntry?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(icon = {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.title
                )
            },
                label = { Text(text = screen.title) },
                selected = currentSelectedItem == screen.route,
                onClick = {
                    if (currentSelectedItem != screen.route) {
                        currentSelectedItem = screen.route
                        navController.navigate(screen.route) {
                            popUpTo(screen.route) {
                                inclusive = true
                                navController.popBackStack()
                            }
                            launchSingleTop = true
                        }
                    }
                })
        }
    }
}