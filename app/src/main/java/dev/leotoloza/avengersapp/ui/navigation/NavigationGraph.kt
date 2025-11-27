package dev.leotoloza.avengersapp.ui.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.ui.screens.SplashScreen
import dev.leotoloza.avengersapp.ui.screens.characters.CharacterDetailScreen
import dev.leotoloza.avengersapp.ui.screens.characters.CharactersScreen
import dev.leotoloza.avengersapp.ui.screens.controlPanel.PanelControlScreen
import dev.leotoloza.avengersapp.ui.screens.favorites.FavoritesScreen
import dev.leotoloza.avengersapp.ui.viewmodels.CharactersViewModel
import dev.leotoloza.avengersapp.ui.viewmodels.FavoritesViewModel
import dev.leotoloza.avengersapp.ui.viewmodels.PanelControlViewModel

internal const val MAIN_APP_GRAPH_ROUTE = "main_app_graph"
internal const val CHARACTERS_GRAPH_ROUTE = "characters_graph"

@Composable
fun NavGraph(
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
    onTitleChange: (String) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
    ) {
        composable(Screens.Splash.route) {
            SplashScreen(onNavigateToNextScreen = {
                navController.navigate(MAIN_APP_GRAPH_ROUTE) { // navega al grafo principal
                    popUpTo(Screens.Splash.route) {
                        inclusive = true // Elimina Splash del back stack para que no sea navegable
                    }
                }
            })
        }

        // Main app graph contiene las pantallas principales de la bottomBar
        navigation(startDestination = CHARACTERS_GRAPH_ROUTE, route = MAIN_APP_GRAPH_ROUTE) {
            // Characters graph anidado para optimizacion del ciclo de vida del ViewModel
            // y que no se recomponga siempre que se navegue a otra pantalla desde la bottomBar.
            // Mantiene los datos que trae de la api cargados como cache.
            navigation(
                startDestination = Screens.Characters.route, route = CHARACTERS_GRAPH_ROUTE
            ) {
                composable(Screens.Characters.route) { entry ->
                    onTitleChange("Marvel Challenge")
                    // CharactersViewModel con alcance en CHARACTERS_GRAPH_ROUTE
                    val parentEntry = remember(entry) {
                        navController.getBackStackEntry(CHARACTERS_GRAPH_ROUTE)
                    }
                    val charactersViewModel: CharactersViewModel = hiltViewModel(parentEntry)
                    CharactersScreen(
                        navController = navController,
                        viewModel = charactersViewModel,
                        snackbarHostState = snackbarHostState
                    )
                }
                composable(
                    route = Screens.CharacterDetail.route,
                    arguments = listOf(navArgument(Screens.CharacterDetail.NAV_ARG_CHARACTER_ID) { type = NavType.LongType })
                ) { entry ->
                    val parentEntry = remember(entry) {
                        navController.getBackStackEntry(CHARACTERS_GRAPH_ROUTE)
                    }
                    val charactersViewModel: CharactersViewModel = hiltViewModel(parentEntry)
                    val selectedCharacterId = entry.arguments?.getLong(Screens.CharacterDetail.NAV_ARG_CHARACTER_ID)
                    val character: Character? = selectedCharacterId?.let { charactersViewModel.getCharacterById(it) }

                    character?.let { char ->
                        onTitleChange(char.name.uppercase())
                        LaunchedEffect(Unit) {
                            charactersViewModel.logCharacterViewed(char)
                        }
                        CharacterDetailScreen(character = char)
                    } ?: run { // Si character es null (id no valido), navega hacia atras
                        LaunchedEffect(Unit) {
                            navController.navigateUp()
                        }
                    }
                }
            }

            // EventsScreen es parte del grafo principal, no del de characters
            composable(Screens.PanelControl.route) { entry ->
                val panelControlViewModel: PanelControlViewModel = hiltViewModel(entry)
                PanelControlScreen(
                    viewModel = panelControlViewModel,
                    onNavigateToFavorites = {
                        navController.navigate(Screens.Favorites.route)
                    }
                )
            }

            composable(Screens.Favorites.route) { entry ->
                onTitleChange("Favoritos")
                val favoritesViewModel: FavoritesViewModel = hiltViewModel(entry)
                FavoritesScreen(
                    viewModel = favoritesViewModel
                )
            }
        }
    }
}