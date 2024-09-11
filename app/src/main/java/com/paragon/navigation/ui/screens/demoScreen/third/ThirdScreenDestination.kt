package com.paragon.navigation.ui.screens.demoScreen.third

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object ThirdScreenDestination {
    const val route = "third_screen_route"
}

fun NavGraphBuilder.thirdScreenGraph(onBackPressed : (String?) -> Unit ,  openFourthScreen  :(String?) -> Unit) {
    composable(arguments = listOf(navArgument("data") {
        defaultValue = "No Data Received"
        type = NavType.StringType
    }), route = "${ThirdScreenDestination.route}/{data}") {
        val data = it.arguments?.getString("data")
        val backPressedData = it.savedStateHandle.get<String>("data")
        ThirdScreen(data =  data , backPressedData = backPressedData, openFourthScreen = openFourthScreen , onBackPressed = onBackPressed)
    }
}