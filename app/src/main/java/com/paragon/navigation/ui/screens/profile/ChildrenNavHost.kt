package com.paragon.navigation.ui.screens.profile

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ChildrenNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ProfileScreenNavigation.Child1.route
    ) {
        composable(ProfileScreenNavigation.Child1.route) {
            ProfileChildren_1(open = {
                navController.navigate(ProfileScreenNavigation.Child2.route)
            })
        }
        composable(ProfileScreenNavigation.Child2.route) {
            ProfileChildren_2(open = {
                navController.navigate(ProfileScreenNavigation.Child3.route)
            })
        }
        composable(ProfileScreenNavigation.Child3.route) {
            ProfileChildren_3(open = {
                navController.navigate(ProfileScreenNavigation.Child4.route)
            })
        }
        composable(ProfileScreenNavigation.Child4.route) { ProfileChildren_4() }
    }

}
