package dev.leotoloza.avengersapp.ui.screens.characters

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import dev.leotoloza.avengersapp.ui.screens.characters.components.CharactersList
import dev.leotoloza.avengersapp.ui.screens.common.LoadingScreen
import dev.leotoloza.avengersapp.ui.viewmodels.CharactersViewModel
import kotlinx.coroutines.launch

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel,
    snackbarHostState: SnackbarHostState
) {
    val uiState by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()

    // Observa el estado de error del ViewModel
    LaunchedEffect(uiState.error) {
        uiState.error?.let { errorMsg ->
            scope.launch {
                val result = snackbarHostState.showSnackbar(
                    message = errorMsg,
                    withDismissAction = true,
                    actionLabel = "Reintentar",
                )
                // Si el usuario presiona "Reintentar", llama al ViewModel
                if (result == SnackbarResult.ActionPerformed) {
                    viewModel.getCharacters()
                }
                // Una vez mostrado (o descartado), notifica al ViewModel
                viewModel.onErrorShown()
            }
        }
    }

    when{
        uiState.isLoading && uiState.characters.isEmpty() -> {
            LoadingScreen()
        }
        else -> {
            CharactersList(
                charactersList = uiState.characters,
                favorites = uiState.favorites,
                navController = navController,
                isLoadingMore = uiState.isLoadingMore,
                onLoadMore = { viewModel.getCharacters() },
                onToggleFavorite = { character -> viewModel.toggleFavorite(character) }
            )
        }
    }
}