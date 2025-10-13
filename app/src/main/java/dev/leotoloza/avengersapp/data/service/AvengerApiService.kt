package dev.leotoloza.avengersapp.data.service

import dev.leotoloza.avengersapp.BuildConfig
import dev.leotoloza.avengersapp.data.service.security.HashKeyBuilder
import javax.inject.Inject

class AvengerApiService @Inject constructor(
    private val apiClient: AvengersClient,
    hashKeyBuilder: HashKeyBuilder,
) {
    private val hashKey = hashKeyBuilder.build(
        timestamp = TIME_STAMP.toString(),
        privateKey = BuildConfig.API_PRIVATE_KEY,
        publicKey = BuildConfig.API_PUBLIC_KEY
    )
    private val publicKey = BuildConfig.API_PUBLIC_KEY

    suspend fun getCharacters(page: Int) = apiClient.getCharacters(
        publicApiKey = publicKey,
        hash = hashKey,
        offset = (page * CHARACTERS_PER_PAGE),
    )
}