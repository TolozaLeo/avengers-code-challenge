package dev.leotoloza.avengersapp.ui.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import dev.leotoloza.avengersapp.ui.common.LoadingScreen

@Composable
fun EventsScreen(
    viewModel: EventsViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsState()

    when(val state = uiState.value) {
        is EventsUiState.Loading -> {
            LoadingScreen()
        }
        is EventsUiState.Success -> {
            EventsList(eventsList = state.events)
        }
        is EventsUiState.Error -> {
            // Mostrar un mensaje de error
        }
    }
}