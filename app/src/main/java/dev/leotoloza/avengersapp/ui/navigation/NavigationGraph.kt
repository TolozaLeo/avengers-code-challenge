package dev.leotoloza.avengersapp.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.ui.characters.CharacterDetailScreen
import dev.leotoloza.avengersapp.ui.characters.CharactersScreen
import dev.leotoloza.avengersapp.ui.common.SplashScreen
import dev.leotoloza.avengersapp.ui.events.EventsScreen

//TODO ARREGLAR DEPENDENCIAS DE HILT

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
                navController = navController,)
        }
        composable(Screens.CharacterDetail.route) { backStackEntry ->
            val character: Character? = backStackEntry.savedStateHandle["selectedCharacter"]

            if (character != null) {
                CharacterDetailScreen(character = character)
            } else {
                LaunchedEffect(Unit) {
                    Log.e("CharacterDetail", "Character is null, navigating back")
                    navController.navigateUp()
                }
            }
        }
        composable(Screens.Events.route) {
            EventsScreen()
        }
    }
}