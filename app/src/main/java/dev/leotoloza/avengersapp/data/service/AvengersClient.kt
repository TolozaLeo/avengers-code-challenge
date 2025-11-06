package dev.leotoloza.avengersapp.data.service

import dev.leotoloza.avengersapp.data.remote.model.CharacterItem
import dev.leotoloza.avengersapp.data.remote.model.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val CHARACTERS_PER_PAGE = 15

interface AvengersClient {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = CHARACTERS_PER_PAGE // La API de Disney soporta esto
    ): CharactersResponse<CharacterItem>
}