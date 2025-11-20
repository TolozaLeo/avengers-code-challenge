package dev.leotoloza.avengersapp.domain.usecases

import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.FavoritesRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(character: Character) {
        repository.toggleFavorite(character)
    }
}
