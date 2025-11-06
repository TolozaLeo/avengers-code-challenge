package dev.leotoloza.avengersapp.data.service

import dev.leotoloza.avengersapp.BuildConfig
import dev.leotoloza.avengersapp.data.service.security.HashKeyBuilder
import java.util.Date
import javax.inject.Inject

class AvengerApiService @Inject constructor(
    private val apiClient: AvengersClient,
    private val hashKeyBuilder: HashKeyBuilder,
) {
    private val publicKey = BuildConfig.API_PUBLIC_KEY
    private val privateKey = BuildConfig.API_PRIVATE_KEY

    // Genera ts y hash nuevos para cada llamada
    suspend fun getCharacters(page: Int) = apiClient.getCharacters(
        page = page,
        pageSize = 25,
    )

    suspend fun getEvents(page: Int) = run {
        val ts = Date().time.toString()
        val hash = hashKeyBuilder.build(
            timestamp = ts, privateKey = privateKey, publicKey = publicKey
        )
        apiClient.getEvents(
            ts = ts.toLong(), // Pasa el ts nuevo
            publicApiKey = publicKey,
            hash = hash, // Pasa el hash nuevo
            offset = (page * EVENTS_PER_PAGE),
        )
    }
}