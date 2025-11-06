package dev.leotoloza.avengersapp.data.service

import dev.leotoloza.avengersapp.data.remote.model.CharacterItem
import dev.leotoloza.avengersapp.data.remote.model.CharactersResponse
import dev.leotoloza.avengersapp.data.remote.model.EventsResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val CHARACTERS_PER_PAGE = 15

/*Por algún motivo cuando pido más de 12 eventos o cuando los ordeno "-startDate"
 la api devuelve código 200(respuesta ok), pero la respuesta es un string vacío.
 La app lanza una excepcion por tener todos los campos esperados como nulos. */
const val EVENTS_PER_PAGE = 12
//const val START_DATE = "-startDate" //Ordena de más reciente a más antiguo

interface AvengersClient {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 50 // La API de Disney soporta esto
    ): CharactersResponse<CharacterItem>

    @GET("events")
    suspend fun getEvents(
        @Query("ts") ts: Long,
        @Query("apikey") publicApiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = EVENTS_PER_PAGE,
//        @Query("orderBy") orderBy: String = START_DATE
    ): EventsResponse
}