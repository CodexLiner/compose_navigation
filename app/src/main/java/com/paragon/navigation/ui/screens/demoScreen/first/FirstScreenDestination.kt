package com.paragon.navigation.ui.screens.demoScreen.first

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object FirstScreenDestination {
    const val route = "first_screen_route"
}

fun NavGraphBuilder.firstScreenGraph(openSecondScreen : (String?) -> Unit) {
    composable(arguments = listOf(navArgument("data") {
        defaultValue = "No Data Received"
        type = NavType.StringType
    }), route = "${FirstScreenDestination.route}/{data}") {
        val data = it.arguments?.getString("data")
        val backPressedData = it.savedStateHandle.get<String>("data")
        FirstScreen(openSecondScreen = openSecondScreen , data = data , backPressedData = backPressedData)
    }
}