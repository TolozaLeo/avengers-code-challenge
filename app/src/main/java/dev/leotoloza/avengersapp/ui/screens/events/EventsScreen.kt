package dev.leotoloza.avengersapp.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import dev.leotoloza.avengersapp.ui.screens.common.LoadingScreen
import dev.leotoloza.avengersapp.ui.screens.events.components.EventsList
import dev.leotoloza.avengersapp.ui.viewmodels.EventsUiState
import dev.leotoloza.avengersapp.ui.viewmodels.EventsViewModel

@Composable
fun EventsScreen(
    viewModel: EventsViewModel,
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