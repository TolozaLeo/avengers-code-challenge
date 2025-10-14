package dev.leotoloza.avengersapp.domain.repository

import dev.leotoloza.avengersapp.domain.model.Event

interface EventsRepository {
    suspend fun getEvents(page : Int): Result<List<Event>>
}