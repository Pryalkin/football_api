package com.bsuir.football.app.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bsuir.football.Singletons
import com.bsuir.football.app.screen.graphs.RootNavigationGraph
import com.bsuir.football.app.utils.observeEvent
import com.bsuir.football.app.views.AppViewModel
import com.bsuir.football.ui.theme.FootballTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AppViewModel>()
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        Singletons.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContent {
            FootballTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
        observeShowAuthMessageEvent()
    }

    private fun observeShowAuthMessageEvent() = viewModel.message.observeEvent(lifecycleOwner = this) {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }


}

