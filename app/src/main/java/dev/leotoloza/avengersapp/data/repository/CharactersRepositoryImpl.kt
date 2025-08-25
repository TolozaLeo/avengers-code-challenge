package dev.leotoloza.avengersapp.data.repository

import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.CharactersRepository
import javax.inject.Inject

//TODO Implementar llamada a API
class CharactersRepositoryImpl @Inject constructor() : CharactersRepository {
    override suspend fun getCharacters(limit: Int, offset: Int): Result<List<Character>> {
        return try {
            Result.success(emptyList())
        } catch (e: Exception, ) {
            Result.failure(e)
        }
    }
}