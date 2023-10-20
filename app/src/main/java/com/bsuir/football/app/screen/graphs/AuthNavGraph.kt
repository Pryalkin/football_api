package com.bsuir.football.app.screen.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bsuir.football.app.screen.screens.LoginContent
import com.bsuir.football.app.screen.screens.Screen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Screen.Authentication.route,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginContent(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
}