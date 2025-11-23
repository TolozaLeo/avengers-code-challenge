package dev.leotoloza.avengersapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.jvm.Throws

data class EventsUiState(
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class PanelControlViewModel @Inject constructor(
) : ViewModel() {
    private val _uiState = MutableStateFlow(EventsUiState())
    val uiState: StateFlow<EventsUiState> = _uiState

    fun onForceCrash() {
        throw RuntimeException("Crash forzado desde el Panel de Control")
    }

    fun onErrorShown() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
