package dev.leotoloza.avengersapp.ui.screens.events

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.leotoloza.avengersapp.ui.screens.common.LoadingScreen
import dev.leotoloza.avengersapp.ui.screens.events.components.EventsList
import dev.leotoloza.avengersapp.ui.viewmodels.EventsViewModel

@Composable
fun EventsScreen(
    viewModel: EventsViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    when{
        uiState.isLoading && uiState.events.isEmpty() -> {
            LoadingScreen()
        }
        uiState.error != null -> {
            // TODO Mostrar un mensaje de error
            Log.e("EventsScreen", "Error: ${uiState.error}")
        }
        else -> {
            EventsList(
                eventsList = uiState.events,
                isLoadingMore = uiState.isLoadingMore,
                onLoadMore = { viewModel.getEvents() }
            )
        }
    }
}