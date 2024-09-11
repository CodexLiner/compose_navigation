package com.paragon.navigation.ui.screens.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object ProfileDestination {
    const val route = "profile_route"
    const val destination = "profile_destination"
}

fun NavGraphBuilder.profileGraph() {
    composable(route = ProfileDestination.route) {
        ProfileScreen()
    }
}