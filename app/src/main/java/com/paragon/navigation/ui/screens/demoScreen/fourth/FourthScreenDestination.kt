package com.paragon.navigation.ui.screens.demoScreen.fourth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object FourthScreenDestination {
    const val route = "fourth_screen_route"
}

fun NavGraphBuilder.fourthScreenGraph(onBackPressed : (String?) -> Unit , openFirstWhileDestroyingCurrentScreen : (String?) -> Unit) {
    composable(arguments = listOf(navArgument("data") {
        defaultValue = "No Data Received"
        type = NavType.StringType
    }), route = "${FourthScreenDestination.route}/{data}") {
        val data = it.arguments?.getString("data")
        FourthScreen(onBackPressed = onBackPressed, data = data , openFirstWhileDestroyingCurrentScreen = openFirstWhileDestroyingCurrentScreen  )
    }
}