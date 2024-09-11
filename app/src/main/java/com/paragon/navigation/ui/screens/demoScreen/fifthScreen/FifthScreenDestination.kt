package com.paragon.navigation.ui.screens.demoScreen.fifthScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object FifthScreenDestination {
    const val route = "fifth_screen_route"
}

fun NavGraphBuilder.fifthScreenGraph(openFirstScreen : (String?) -> Unit) {
    composable(arguments = listOf(navArgument("data") {
        defaultValue = "No Data Received"
        type = NavType.StringType
    }), route = FifthScreenDestination.route) {
        FifthScreen(openFirstScreen = openFirstScreen)
    }
}