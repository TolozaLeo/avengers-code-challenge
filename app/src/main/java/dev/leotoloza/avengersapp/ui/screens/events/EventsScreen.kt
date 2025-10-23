package dev.leotoloza.avengersapp.ui.screens.events

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import dev.leotoloza.avengersapp.ui.screens.common.LoadingScreen
import dev.leotoloza.avengersapp.ui.screens.events.components.EventsList
import dev.leotoloza.avengersapp.ui.viewmodels.EventsViewModel
import kotlinx.coroutines.launch

@Composable
fun EventsScreen(
    viewModel: EventsViewModel,
    snackbarHostState: SnackbarHostState
) {
    val uiState by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()

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
                    viewModel.getEvents()
                }
                // Una vez mostrado (o descartado), notifica al ViewModel
                viewModel.onErrorShown()
            }
        }
    }

    when{
        uiState.isLoading && uiState.events.isEmpty() -> {
            LoadingScreen()
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