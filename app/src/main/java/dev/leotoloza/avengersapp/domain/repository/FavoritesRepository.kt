package dev.leotoloza.avengersapp.domain.repository

import dev.leotoloza.avengersapp.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    suspend fun toggleFavorite(character: Character)
    fun getFavorites(): Flow<List<Character>>
    suspend fun isFavorite(characterId: Long): Boolean
}
