package dev.leotoloza.avengersapp.domain.usecases

import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.domain.repository.EventsRepository
import javax.inject.Inject

class GetEventsUseCase
@Inject constructor(
    private val repository: EventsRepository,
) {
    suspend operator fun invoke(
        page: Int,
    ): Result<List<Event>> {
        return repository.getEvents(page)
    }
}