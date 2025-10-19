package dev.leotoloza.avengersapp.ui.screens.characters

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import dev.leotoloza.avengersapp.ui.screens.characters.components.CharactersList
import dev.leotoloza.avengersapp.ui.screens.common.LoadingScreen
import dev.leotoloza.avengersapp.ui.viewmodels.CharactersViewModel

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    when{
        uiState.isLoading && uiState.characters.isEmpty() -> {
            LoadingScreen()
        }
        uiState.error != null -> {
            // TODO Mostrar un mensaje de error
            Log.e("CharactersScreen", "Error: ${uiState.error}")
        }
        else -> {
            CharactersList(
                charactersList = uiState.characters,
                navController = navController,
                isLoadingMore = uiState.isLoadingMore,
                onLoadMore = { viewModel.getCharacters() }
            )
        }
    }
}