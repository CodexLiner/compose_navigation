package com.paragon.navigation.ui.screens.demoScreen.second

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object SecondScreenNavigation {
    const val route = "second_screen_route"
    }

fun NavGraphBuilder.secondScreenGraph(onBackPressed : (String?) -> Unit ,  openThirdScreen : (String?) -> Unit) {
    composable(arguments = listOf(navArgument("data") {
        defaultValue = "No Data Received"
        type = NavType.StringType
    }), route = "${SecondScreenNavigation.route}/{data}") {
        val data = it.arguments?.getString("data")
        val backPressedData = it.savedStateHandle.get<String>("data")
        SecondScreen(data = data , openThirdScreen = openThirdScreen , backPressedData = backPressedData, onBackPressed = onBackPressed)
    }

}