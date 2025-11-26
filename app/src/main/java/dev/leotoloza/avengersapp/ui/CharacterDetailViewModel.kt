package dev.leotoloza.avengersapp.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.data.repository.FirebaseRepository
import javax.inject.Inject
import dev.leotoloza.avengersapp.analytics.AnalyticsManager

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val repository: FirebaseRepository
) : ViewModel() {

    fun onAddFavorite(userId: String, characterId: Int, characterName: String) {
        repository.addFavorite(userId, characterId, characterName)
    }


    fun onCharacterViewed(characterId: Int, characterName: String) {
        analytics.logCharacterViewed(characterId, characterName)
    }

    fun setUserInfo(age: Int, nationality: String) {
        analytics.setUserAge(age)
        analytics.setUserNationality(nationality)
    }
}
}