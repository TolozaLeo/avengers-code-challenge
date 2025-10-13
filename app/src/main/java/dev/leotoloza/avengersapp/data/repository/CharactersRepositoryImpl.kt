package dev.leotoloza.avengersapp.data.repository

import dev.leotoloza.avengersapp.data.remote.mapper.toDomain
import dev.leotoloza.avengersapp.data.service.AvengerApiService
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val apiService: AvengerApiService
) : CharactersRepository {
    override suspend fun getCharacters(offset: Int): Result<List<Character>> {
        return try{
            val response = apiService.getCharacters(offset)
            val characters = response.data.results.map{ it.toDomain() }
            Result.success(characters)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}