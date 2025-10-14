package dev.leotoloza.avengersapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.domain.usecases.GetEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class EventsUiState {
    object Loading : EventsUiState()
    data class Success(val events: List<Event>) : EventsUiState()
    data class Error(val errorMessage: String) : EventsUiState()
}

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<EventsUiState>(EventsUiState.Loading)
    val uiState: StateFlow<EventsUiState> = _uiState

    private var cachedEvents: MutableList<Event> = emptyList<Event>().toMutableList()

    init {
        getEvents(0)
    }

    fun getEvents(page: Int) {
        if (cachedEvents.isNotEmpty()) {
            _uiState.value = EventsUiState.Success(cachedEvents)
            return
        }
        viewModelScope.launch {
            _uiState.value = EventsUiState.Loading
            getEventsUseCase(page).onSuccess { events ->
                    cachedEvents.addAll(events)
                    _uiState.value = EventsUiState.Success(cachedEvents)
                }.onFailure { error ->
                    _uiState.value = EventsUiState.Error(error.message ?: "Error de conexion")
//                    cachedEvents.addAll(getHardCodedList()) Si hay un error, carga la lista hardcodeada
//                    _uiState.value = EventsUiState.Success(cachedEvents)
                }
        }
    }
}
