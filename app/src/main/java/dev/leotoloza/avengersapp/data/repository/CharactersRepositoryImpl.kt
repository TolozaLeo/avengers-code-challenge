package dev.leotoloza.avengersapp.data.repository

import dev.leotoloza.avengersapp.data.remote.mapper.toDomain
import dev.leotoloza.avengersapp.data.service.AvengerApiService
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val apiService: AvengerApiService
) : CharactersRepository {
    override suspend fun getCharacters(page: Int): Result<List<Character>> {
        return try{
            val response = apiService.getCharacters(page)
            val characters = response.data.results.map{ it.toDomain() }
            Result.success(characters)
        } catch (e: Exception) {
            //TODO Manejar mensajes de error con un wrapper
            Result.failure(e)
        }
    }
}