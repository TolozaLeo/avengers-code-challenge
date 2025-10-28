package dev.leotoloza.avengersapp.data.service

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
    @GET("characters")
    suspend fun getCharacters(
        @Query("ts") ts: Long,
        @Query("apikey") publicApiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,// a partir de que elemento se pide
        @Query("limit") limit: Int = CHARACTERS_PER_PAGE,
    ): CharactersResponse

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