package dev.leotoloza.avengersapp.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.data.repository.FirebaseRepository
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val repository: FirebaseRepository
) : ViewModel() {

    fun onAddFavorite(userId: String, characterId: Int, characterName: String) {
        repository.addFavorite(userId, characterId, characterName)
    }
}