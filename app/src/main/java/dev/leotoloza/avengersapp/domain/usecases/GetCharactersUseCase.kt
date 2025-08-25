package dev.leotoloza.avengersapp.domain.usecases

import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase
@Inject constructor(
    private val repository: CharactersRepository,
) {
    suspend operator fun invoke(
        limit: Int,
        offset: Int,
    ): Result<List<Character>> {
        return repository.getCharacters(limit, offset)
    }
}