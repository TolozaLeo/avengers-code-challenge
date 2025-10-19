package dev.leotoloza.avengersapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.data.service.CHARACTERS_PER_PAGE
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CharactersUiState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList(),
    val error: String? = null,
    val isLoadingMore: Boolean = false, // Para el indicador de carga inferior
    val allDataLoaded: Boolean = false // Para saber si llegamos al final
)

@HiltViewModel
class CharactersViewModel
@Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(CharactersUiState())
    val uiState: StateFlow<CharactersUiState> = _uiState

    private var currentPage = 0

    init {
        getCharacters()
    }

    fun getCharacters() {
        // Evita múltiples llamadas si ya se está cargando o si se cargaron todos los datos
        if (_uiState.value.isLoadingMore || _uiState.value.allDataLoaded) return

        viewModelScope.launch {
            // Distingue entre la carga inicial y la paginación
            if (currentPage == 0) {
                _uiState.value = _uiState.value.copy(isLoading = true)
            } else {
                _uiState.value = _uiState.value.copy(isLoadingMore = true)
            }

            getCharactersUseCase(currentPage).onSuccess { newCharacters ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false, isLoadingMore = false,
                    // Añade los nuevos personajes a la lista existente
                    characters = _uiState.value.characters + newCharacters,
                    // Si la API devuelve menos elementos de los pedidos, asumimos que es la última página
                    allDataLoaded = isAllDataLoaded(newCharacters.size)
                )
                currentPage++
            }.onFailure {
                _uiState.value = _uiState.value.copy(
                    isLoading = false, isLoadingMore = false, error = it.message
                )
            }
        }
    }

    fun getCharacterById(id: Long): Character? {
        return _uiState.value.characters.find { it.id == id }
    }

    private fun isAllDataLoaded(numberOfCharactersGotten: Int): Boolean {
        // CHARACTERS_PER_PAGE es la cantidad que se pide para cargar por página
        return numberOfCharactersGotten < CHARACTERS_PER_PAGE
    }
}
