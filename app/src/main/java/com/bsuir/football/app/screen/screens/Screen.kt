package com.bsuir.football.app.screen.screens

sealed class Screen(val route: String) {
    object Root: Screen(route = "root_screen")
    object Authentication: Screen(route = "auth_graph")
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen")
    object DetailId: Screen(route = "detail_screen/{id}")
}
