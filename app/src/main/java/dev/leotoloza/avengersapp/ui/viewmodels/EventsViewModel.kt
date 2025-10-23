package dev.leotoloza.avengersapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.data.service.EVENTS_PER_PAGE
import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.domain.usecases.GetEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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
    private val getEventsUseCase: GetEventsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(EventsUiState())
    val uiState: StateFlow<EventsUiState> = _uiState

    private var currentPage = 0

    init {
        getEvents()
    }

    fun getEvents() {
        if (_uiState.value.isLoadingMore || _uiState.value.allDataLoaded) return
        viewModelScope.launch {
            // Distingue entre la carga inicial y la paginación
            if (currentPage == 0) {
                _uiState.value = _uiState.value.copy(isLoading = true)
            } else {
                _uiState.value = _uiState.value.copy(isLoadingMore = true)
            }

            getEventsUseCase(currentPage).onSuccess { newEvents ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false, isLoadingMore = false,
                    // Añade los nuevos eventos a la lista existente
                    events = _uiState.value.events + newEvents,
                    // Si la API devuelve menos elementos de los pedidos, asumimos que es la última página
                    allDataLoaded = isAllDataLoaded(newEvents.size)
                )
                currentPage++
            }.onFailure {
                _uiState.value = _uiState.value.copy(
                    isLoading = false, isLoadingMore = false, error = it.message
                )
            }
        }
    }

    fun onErrorShown() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    private fun isAllDataLoaded(numberOfEventsGotten: Int): Boolean {
//        EVENTS_PER_PAGE es la cantidad que se pide para cargar por página
        return numberOfEventsGotten < EVENTS_PER_PAGE
    }
}
