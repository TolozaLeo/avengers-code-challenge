package dev.leotoloza.avengersapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class CharactersUiState {
    object Loading : CharactersUiState()
    data class Success(val characters: List<Character>) : CharactersUiState()
    data class Error(val errorMessage: String) : CharactersUiState()
}

@HiltViewModel
class CharactersViewModel
@Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    val uiState: StateFlow<CharactersUiState> = _uiState

    // Guarda la lista para evitar recargar
    private var cachedCharacters: MutableList<Character> = emptyList<Character>().toMutableList()

    init {
        getCharacters(0)
    }

    private fun getCharacters(page: Int) {
        if (cachedCharacters.isNotEmpty()) {// Si hay datos en caché los muestra
            _uiState.value = CharactersUiState.Success(cachedCharacters)
            return
        }
        viewModelScope.launch {
            getCharactersUseCase(page)
                .onSuccess { characters ->
                    cachedCharacters.addAll(characters)
                    _uiState.value = CharactersUiState.Success(cachedCharacters)
                }
                .onFailure { error ->
                    _uiState.value = CharactersUiState.Error(error.message ?: "Unknown Error")
                }
        }
    }

    fun getCharacterById(id: Long): Character? {
        return cachedCharacters.find { it.id == id }
    }
}
