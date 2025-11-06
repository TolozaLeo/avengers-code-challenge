package dev.leotoloza.avengersapp.data.repository

import dev.leotoloza.avengersapp.data.remote.ErrorHandler
import dev.leotoloza.avengersapp.data.remote.mapper.toDomain
import dev.leotoloza.avengersapp.data.service.AvengerApiService
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val apiService: AvengerApiService,
    private val errorHandler: ErrorHandler
) : CharactersRepository {
    override suspend fun getCharacters(page: Int): Result<List<Character>> {
        return try{
            val response = apiService.getCharacters(page)
            val characters = response.data.map{ it.toDomain() }
            Result.success(characters)
        } catch (e: Exception) {
            Result.failure(errorHandler.getError(e))
        }
    }
}