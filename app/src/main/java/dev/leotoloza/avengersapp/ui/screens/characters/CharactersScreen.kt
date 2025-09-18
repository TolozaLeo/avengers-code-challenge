package dev.leotoloza.avengersapp.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import dev.leotoloza.avengersapp.ui.screens.characters.components.CharactersList
import dev.leotoloza.avengersapp.ui.viewmodels.CharactersUiState
import dev.leotoloza.avengersapp.ui.viewmodels.CharactersViewModel
import dev.leotoloza.avengersapp.ui.screens.common.LoadingScreen

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel,
) {
    val state = viewModel.uiState.collectAsState()
    when (val uiState = state.value) {
        is CharactersUiState.Loading -> {
            LoadingScreen()
        }
        is CharactersUiState.Success -> {
            CharactersList(
                charactersList = uiState.characters,
                navController = navController,
            )
        }
        is CharactersUiState.Error -> {
            // Mostrar un mensaje de error
        }
    }
}