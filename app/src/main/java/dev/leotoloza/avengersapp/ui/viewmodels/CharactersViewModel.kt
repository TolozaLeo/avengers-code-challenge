package dev.leotoloza.avengersapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.data.service.CHARACTERS_PER_PAGE
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.usecases.GetCharactersUseCase
import dev.leotoloza.avengersapp.ui.utils.UiErrorProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CharactersUiState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList(),
    val favorites: List<Character> = emptyList(),
    val error: String? = null,
    val isLoadingMore: Boolean = false, // Para el indicador de carga inferior
    val allDataLoaded: Boolean = false // Para saber si llegamos al final
)

@HiltViewModel
class CharactersViewModel
@Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val toggleFavoriteUseCase: dev.leotoloza.avengersapp.domain.usecases.ToggleFavoriteUseCase,
    private val getFavoritesUseCase: dev.leotoloza.avengersapp.domain.usecases.GetFavoritesUseCase,
    private val errorProvider: UiErrorProvider,
    private val analyticsManager: dev.leotoloza.avengersapp.data.service.firebase.AnalyticsManager
) : ViewModel() {
    private val _uiState = MutableStateFlow(CharactersUiState())
    val uiState: StateFlow<CharactersUiState> = _uiState
    private var currentPage = 1

    init {
        getCharacters()
        observeFavorites()
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase().collect { favorites ->
                _uiState.value = _uiState.value.copy(favorites = favorites)
            }
        }
    }

    fun toggleFavorite(character: Character) {
        viewModelScope.launch {
            try {
                val isFavorite = _uiState.value.favorites.any { it.id == character.id }
                if (!isFavorite) {
                    analyticsManager.logFavoriteAdded(character.id.toInt(), character.name)
                }
                toggleFavoriteUseCase(character)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = errorProvider.getErrorMessage(e))
            }
        }
    }

    fun logCharacterViewed(character: Character) {
        analyticsManager.logCharacterViewed(character.id.toInt(), character.name)
    }

    fun getCharacters() {
        // Evita múltiples llamadas si ya se está cargando o si se cargaron todos los datos
        if (_uiState.value.isLoadingMore || _uiState.value.allDataLoaded) return

        viewModelScope.launch {
            // Distingue entre la carga inicial y la paginación
            if (currentPage == 1) {
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
                    allDataLoaded = isAllDataLoaded(newCharacters.size),
                    error = null
                )
                currentPage++
            }.onFailure { exception ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isLoadingMore = false,
                    error = errorProvider.getErrorMessage(exception)
                )
            }
        }
    }

    fun onErrorShown() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    fun getCharacterById(id: Long): Character? {
        return _uiState.value.characters.find { it.id == id }
    }

    private fun isAllDataLoaded(numberOfCharactersGotten: Int): Boolean {
        // CHARACTERS_PER_PAGE es la cantidad que se pide para cargar por página
        return numberOfCharactersGotten < CHARACTERS_PER_PAGE
    }
}
