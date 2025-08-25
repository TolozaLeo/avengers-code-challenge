package dev.leotoloza.avengersapp.domain.repository

import dev.leotoloza.avengersapp.domain.model.Character

interface CharactersRepository {
    suspend fun getCharacters(limit : Int, offset : Int): Result<List<Character>>
}