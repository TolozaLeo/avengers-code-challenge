package dev.leotoloza.avengersapp.data.repository

import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.domain.repository.EventsRepository
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(): EventsRepository {
    override suspend fun getEvents(
        limit: Int,
        offset: Int
    ): Result<List<Event>> {
        return try {
            Result.success(emptyList())
        } catch (e: Exception, ) {
            Result.failure(e)
        }
    }
}