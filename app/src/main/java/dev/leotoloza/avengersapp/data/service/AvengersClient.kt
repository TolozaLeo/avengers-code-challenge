package dev.leotoloza.avengersapp.data.service

import dev.leotoloza.avengersapp.data.remote.model.CharactersResponse
import dev.leotoloza.avengersapp.data.remote.model.EventsResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val TIME_STAMP = 1L

const val CHARACTERS_PER_PAGE = 15

const val EVENTS_PER_PAGE = 25
const val START_DATE = "startDate"

interface AvengersClient {
    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: Long = TIME_STAMP,
        @Query("apikey") publicApiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,// a partir de que elemento se pide
        @Query("limit") limit: Int = CHARACTERS_PER_PAGE,
    ) : CharactersResponse

    @GET("events")
    suspend fun getEvents(
        @Query("ts") ts: Long = TIME_STAMP,
        @Query("apikey") publicApiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = EVENTS_PER_PAGE,
        @Query("orderBy") orderBy: String = START_DATE
    ) : EventsResponse
}