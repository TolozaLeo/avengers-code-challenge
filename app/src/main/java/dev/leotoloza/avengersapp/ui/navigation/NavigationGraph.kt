package dev.leotoloza.avengersapp.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.ui.characters.CharacterDetailScreen
import dev.leotoloza.avengersapp.ui.characters.CharactersScreen
import dev.leotoloza.avengersapp.ui.characters.CharactersViewModel
import dev.leotoloza.avengersapp.ui.common.SplashScreen
import dev.leotoloza.avengersapp.ui.events.EventsScreen

internal const val MAIN_APP_GRAPH_ROUTE = "main_app_graph"
internal const val CHARACTERS_GRAPH_ROUTE = "characters_graph"

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route, // Splash es el inicio
        modifier = modifier.fillMaxSize()
    ) {
        composable(Screens.Splash.route) {
            SplashScreen(onNavigateToNextScreen = {
                navController.navigate(MAIN_APP_GRAPH_ROUTE) { // navega al grafo principal
                    popUpTo(Screens.Splash.route) { inclusive = true } // Elimina Splash del back stack
                }
            })
        }

        // Main app graph contiene todas las pantallas principales
        navigation(startDestination = CHARACTERS_GRAPH_ROUTE, route = MAIN_APP_GRAPH_ROUTE) {
            // Characters graph anidado (para optimizacion del ciclo de vida del ViewModel
            // y que no se recomponga siempre que se navegue a otra pantalla. Mantiene el cache)
            navigation(startDestination = Screens.Characters.route, route = CHARACTERS_GRAPH_ROUTE) {
                composable(Screens.Characters.route) { navBackStackEntry ->
                    // CharactersViewModel con alcance en CHARACTERS_GRAPH_ROUTE
                    val parentEntry = remember(navBackStackEntry) {
                        navController.getBackStackEntry(CHARACTERS_GRAPH_ROUTE)
                    }
                    val charactersViewModel: CharactersViewModel = hiltViewModel(parentEntry)
                    CharactersScreen(
                        navController = navController,
                        viewModel = charactersViewModel
                    )
                }
                composable(Screens.CharacterDetail.route) { backStackEntry ->
                    val character: Character? = backStackEntry.savedStateHandle["selectedCharacter"]
                    if (character != null) {
                        CharacterDetailScreen(character = character)
                    } else {
                        LaunchedEffect(Unit) {
                            navController.navigateUp()
                        }
                    }
                }
            }

            // EventsScreen es parte del grafo principal, no del de characters
            composable(Screens.Events.route) {
                EventsScreen()
            }
        }
    }
}
