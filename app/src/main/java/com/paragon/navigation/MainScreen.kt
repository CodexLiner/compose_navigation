package com.paragon.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.paragon.navigation.ui.DeepLinks
import com.paragon.navigation.ui.screens.demoScreen.second.secondScreenGraph
import com.paragon.navigation.ui.screens.book.BookScreen
import com.paragon.navigation.ui.screens.dashboard.DashBoardScreen
import com.paragon.navigation.ui.screens.demoScreen.fifthScreen.FifthScreenDestination
import com.paragon.navigation.ui.screens.demoScreen.fifthScreen.fifthScreenGraph
import com.paragon.navigation.ui.screens.demoScreen.first.FirstScreenDestination
import com.paragon.navigation.ui.screens.demoScreen.first.firstScreenGraph
import com.paragon.navigation.ui.screens.demoScreen.fourth.FourthScreenDestination
import com.paragon.navigation.ui.screens.demoScreen.fourth.fourthScreenGraph
import com.paragon.navigation.ui.screens.demoScreen.second.SecondScreenNavigation
import com.paragon.navigation.ui.screens.demoScreen.third.ThirdScreenDestination
import com.paragon.navigation.ui.screens.home.HomeScreen
import com.paragon.navigation.ui.screens.profile.ProfileScreen
import com.paragon.navigation.ui.screens.demoScreen.third.thirdScreenGraph

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Home : Screen("book?data={data}", "Home", Icons.Filled.Home)
    data object Profile : Screen("profile", "Profile", Icons.Filled.Person)
    data object Book : Screen("book", "Book", Icons.Filled.DateRange)
    data object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
}

@Composable
fun MainScreen(startDestination: String , navController : NavHostController= rememberNavController()) {
    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navController)
    }) { innerPadding ->
        Navigation(navController = navController , startDestination)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home, Screen.Book, Screen.Profile, Screen.Settings
    )
    NavigationBar {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(icon = {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.title
                )
            },
                label = { Text(text = screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

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
