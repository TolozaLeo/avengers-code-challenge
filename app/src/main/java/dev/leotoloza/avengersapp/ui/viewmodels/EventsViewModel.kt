package dev.leotoloza.avengersapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.ui.utils.UiErrorProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class EventsUiState(
    val isLoading: Boolean = true,
    val events: List<Event> = emptyList(),
    val error: String? = null,
    val isLoadingMore: Boolean = false, // Para el indicador de carga inferior
    val allDataLoaded: Boolean = false // Para saber si llegamos al final
)

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val errorProvider: UiErrorProvider,
) : ViewModel() {
    private val _uiState = MutableStateFlow(EventsUiState())
    val uiState: StateFlow<EventsUiState> = _uiState

    init {
        _uiState.value.copy(isLoading = true)
        getEvents()
    }

    fun getEvents() {
        return
    }

    fun onErrorShown() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
