package dev.leotoloza.avengersapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.leotoloza.avengersapp.ui.navigation.BottomBar
import dev.leotoloza.avengersapp.ui.navigation.NavGraph
import dev.leotoloza.avengersapp.ui.navigation.Screens
import dev.leotoloza.avengersapp.ui.navigation.TopBar
import dev.leotoloza.avengersapp.ui.theme.AvengersAppTheme

@Composable
fun MainScreen() {
    AvengersAppTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination?.route

        val snackbarHostState = remember { SnackbarHostState() }
        val shouldShowTopBar = currentDestination != Screens.Splash.route
        var topBarTitle by remember { mutableStateOf("Marvel Challenge") }

        val shouldShowBottomBar =
            currentDestination == Screens.Characters.route || currentDestination == Screens.Events.route

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AnimatedVisibility(
                    visible = shouldShowTopBar, enter = fadeIn(), exit = ExitTransition.None
                ) {
                    TopBar(
                        navController = navController, tittleText = topBarTitle
                    )
                }
            },
            bottomBar = {
                if (shouldShowBottomBar) {
                    BottomBar(
                        navController = navController
                    )
                }
            },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                NavGraph(
                    navController = navController,
                    snackbarHostState = snackbarHostState,
                    onTitleChange = { newTitle -> topBarTitle = newTitle })
            }
        }
    }
}