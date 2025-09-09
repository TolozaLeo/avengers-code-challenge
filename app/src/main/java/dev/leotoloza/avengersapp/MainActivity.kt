package dev.leotoloza.avengersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.leotoloza.avengersapp.ui.common.BottomBar
import dev.leotoloza.avengersapp.ui.common.TopBar
import dev.leotoloza.avengersapp.ui.navigation.NavGraph
import dev.leotoloza.avengersapp.ui.navigation.Screens
import dev.leotoloza.avengersapp.ui.theme.AvengersAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvengersAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry = navController.currentBackStackEntryAsState().value
                val currentDestination = navBackStackEntry?.destination?.route
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        if (currentDestination != Screens.Splash.route) TopBar(navController = navController)
                    },
                    bottomBar = {
                        BottomBar(
                            navController = navController
                        )
                    },
                ) { innerPadding ->
                    NavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}