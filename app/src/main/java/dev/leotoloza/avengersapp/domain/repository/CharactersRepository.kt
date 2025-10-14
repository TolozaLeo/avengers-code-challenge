package dev.leotoloza.avengersapp.domain.repository

import dev.leotoloza.avengersapp.domain.model.Character

interface CharactersRepository {
    suspend fun getCharacters(page : Int): Result<List<Character>>
}