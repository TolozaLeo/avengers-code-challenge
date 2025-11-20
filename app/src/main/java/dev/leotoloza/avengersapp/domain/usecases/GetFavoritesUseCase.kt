package dev.leotoloza.avengersapp.domain.usecases

import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {
    operator fun invoke(): Flow<List<Character>> {
        return repository.getFavorites()
    }
}
