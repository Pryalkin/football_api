package com.bsuir.football.app.screen.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bsuir.football.Singletons
import com.bsuir.football.app.screen.screens.*

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Screen.Home.route,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable (route = BottomBarScreen.Home.route) {
            PhotographyContent()
        }
        composable(route = BottomBarScreen.Profile.route) {
            HomeContext(navController = navController)
        }
        composable(
            route = Screen.DetailId.route,
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                })
        ){
            val viewModel = Singletons.appViewModel
            val football = viewModel.football.observeAsState()
            LaunchedEffect(Unit) {
                viewModel.getLeague(it.arguments?.getString("id").toString())
            }

            football.value?.let { it1 -> DetailScreen(it1.response[0]) }
        }
    }
}

