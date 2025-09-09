package dev.leotoloza.avengersapp.ui.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.leotoloza.avengersapp.ui.common.LoadingScreen

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel(),
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