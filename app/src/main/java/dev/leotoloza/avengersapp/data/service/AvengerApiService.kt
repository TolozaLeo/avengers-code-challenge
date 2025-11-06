package dev.leotoloza.avengersapp.data.service

import javax.inject.Inject

class AvengerApiService @Inject constructor(
    private val apiClient: AvengersClient,
) {
    suspend fun getCharacters(page: Int) = apiClient.getCharacters(
        page = page,
    )
}