package dev.leotoloza.avengersapp.data.repository

import dev.leotoloza.avengersapp.data.remote.mapper.toDomain
import dev.leotoloza.avengersapp.data.service.AvengerApiService
import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.domain.repository.EventsRepository
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val apiService: AvengerApiService,
) : EventsRepository {
    override suspend fun getEvents(page: Int): Result<List<Event>> {
        return try {
            val response = apiService.getEvents(page)
            val events = response.data.results.map { it.toDomain() }
            Result.success(events)
        } catch (e: Exception) {
            //TODO Manejar mensajes de error con un wrapper
            Result.failure(e)
        }
    }
}