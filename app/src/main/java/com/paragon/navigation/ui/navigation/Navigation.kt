package com.paragon.navigation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.paragon.navigation.ui.Screen
import com.paragon.navigation.DeepLinks
import com.paragon.navigation.ui.screens.book.BookScreen
import com.paragon.navigation.ui.screens.dashboard.DashBoardScreen
import com.paragon.navigation.ui.screens.demoScreen.fifthScreen.FifthScreenDestination
import com.paragon.navigation.ui.screens.demoScreen.fifthScreen.fifthScreenGraph
import com.paragon.navigation.ui.screens.demoScreen.first.FirstScreenDestination
import com.paragon.navigation.ui.screens.demoScreen.first.firstScreenGraph
import com.paragon.navigation.ui.screens.demoScreen.fourth.FourthScreenDestination
import com.paragon.navigation.ui.screens.demoScreen.fourth.fourthScreenGraph
import com.paragon.navigation.ui.screens.demoScreen.second.SecondScreenNavigation
import com.paragon.navigation.ui.screens.demoScreen.second.secondScreenGraph
import com.paragon.navigation.ui.screens.demoScreen.third.ThirdScreenDestination
import com.paragon.navigation.ui.screens.demoScreen.third.thirdScreenGraph
import com.paragon.navigation.ui.screens.home.HomeScreen
import com.paragon.navigation.ui.screens.profile.ProfileScreen

@Composable
fun Navigation(navController: NavHostController, startDestination: String = Screen.Home.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Home.route) {
            HomeScreen(openFirstScreen = {
                navController.navigate("${FirstScreenDestination.route}/${it.orEmpty()}")
            })
        }
        fifthScreenGraph(openFirstScreen = {
            navController.navigate("${FirstScreenDestination.route}/${it.orEmpty()}")
        })
        fourthScreenGraph(openFirstWhileDestroyingCurrentScreen = {
            navController.navigate("${FirstScreenDestination.route}/${it.orEmpty()}") {
                popUpTo(Screen.Home.route) {
                    saveState = true
                }
                launchSingleTop = true
            }
        }, onBackPressed = {
            if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                navController.previousBackStackEntry?.savedStateHandle?.set("data", it)
                navController.popBackStack()
            }
        })
        firstScreenGraph(openSecondScreen = {
            navController.navigate("${SecondScreenNavigation.route}/${it.orEmpty()}")
        })
        secondScreenGraph(openThirdScreen = {
            navController.navigate("${ThirdScreenDestination.route}/${it.orEmpty()}")
        }, onBackPressed = {
            if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                navController.previousBackStackEntry?.savedStateHandle?.set("data", it)
                navController.popBackStack()
            }
        })
        thirdScreenGraph(openFourthScreen = {
            navController.navigate("${FourthScreenDestination.route}/${it.orEmpty()}")
        }, onBackPressed = {
            if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                navController.previousBackStackEntry?.savedStateHandle?.set("data", it)
                navController.popBackStack()
            }
        })
        composable(deepLinks = listOf(
            navDeepLink { uriPattern = DeepLinks.profile }
        ), route = Screen.Profile.route) { ProfileScreen() }
        composable(
            arguments = listOf(
                navArgument("data"){
                    type = NavType.StringType
                    defaultValue = ""
                }
            ),
            route = Screen.Book.route,
            deepLinks = listOf(
                navDeepLink { uriPattern = DeepLinks.book }
            ),
        ) {
            BookScreen(it.arguments?.getString("data"))
        }
        composable(
            route = Screen.Settings.route,
            deepLinks = listOf(navDeepLink { uriPattern = DeepLinks.settings }),
        ) {
            DashBoardScreen(openLockedOrientationScreen = {
                navController.navigate(FifthScreenDestination.route)
            })
        }
    }
}
