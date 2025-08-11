package dev.leotoloza.avengersapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.leotoloza.avengersapp.ui.characters.CharacterDetailScreen
import dev.leotoloza.avengersapp.ui.characters.CharactersScreen
import dev.leotoloza.avengersapp.ui.common.SplashScreen
import dev.leotoloza.avengersapp.ui.events.EventsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Screens.Splash.route) {
            SplashScreen(onNavigateToNextScreen = {
                navController.navigate(Screens.Characters.route) {
                    popUpTo(Screens.Splash.route) { inclusive = true }
                }
            })
        }
        composable(Screens.Characters.route) {
            CharactersScreen(
                onItemClicked = {
                    navController.navigate(Screens.CharacterDetail.route)
                })
        }
        composable(Screens.CharacterDetail.route) {
            CharacterDetailScreen()
        }
        composable(Screens.Events.route) {
            EventsScreen()
        }
    }
}