package com.paragon.navigation.ui.screens.dashboard

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.paragon.navigation.ui.screens.profile.ProfileScreen

object DashboardDestination {
    const val route = "dashboard_route"
    const val destination = "dashboard_destination"
}

fun NavGraphBuilder.dashboardGraph() {
    composable(route = DashboardDestination.route) {
        ProfileScreen()
    }
}