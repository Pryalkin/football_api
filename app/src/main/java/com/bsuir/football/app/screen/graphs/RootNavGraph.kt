package com.bsuir.football.app.screen.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bsuir.football.app.screen.screens.Screen
import com.bsuir.football.app.screen.screens.home.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Screen.Root.route,
        startDestination = Screen.Authentication.route
    ) {
        authNavGraph(navController = navController)
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}