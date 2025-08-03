package dev.leotoloza.avengersapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.leotoloza.avengersapp.ui.characters.CharactersScreen
import dev.leotoloza.avengersapp.ui.events.EventsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.characters.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Screens.characters.route){
            CharactersScreen()
        }

        composable(Screens.events.route){
            EventsScreen()
        }
    }
}