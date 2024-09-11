package com.paragon.navigation.ui.screens.book

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object BookDestination {
    const val route = "book_route"
    const val destination = "book_destination"
}

fun NavGraphBuilder.bookGraph() {
    composable(route = BookDestination.route) {
        BookScreen(it.arguments?.getString("data"))
    }
}