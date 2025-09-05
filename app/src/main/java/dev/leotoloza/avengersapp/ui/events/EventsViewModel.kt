package dev.leotoloza.avengersapp.ui.events

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.domain.model.Comic
import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.domain.usecases.GetEventsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
) : ViewModel() {
    // TODO Implementar uiState con StateFlow
    fun getEvents(limit: Int, offset: Int): List<Event> { //TODO Eliminar hardcodeo
        viewModelScope.launch {
            val result = getEventsUseCase(0, 0)
            if (result.isSuccess) {
                Log.d("CharactersViewModel", "Success fetching characters")
            }
            else {
                Log.e("CharactersViewModel", "Error fetching characters")
            }
        }
        return getHardCodedList()
    }

    private fun getHardCodedList(): List<Event> {
        return listOf(
            Event(
                id = 1,
                title = "Event 1",
                description = "Description for Event 1",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 1.1", 2020),
                    Comic("Comic 1.2", 2021)
                )
            ),
            Event(
                id = 2,
                title = "Event 2",
                description = "Description for Event 2",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 2.1", 2020),
                    Comic("Comic 2.2", 2021),
                    Comic("Comic 2.3", 2021),
                    Comic("Comic 2.4", 2021),
                    Comic("Comic 2.5", 2021),
                    Comic("Comic 2.6", 2021),
                    Comic("Comic 2.7", 2021),
                    Comic("Comic 2.8", 2021),
                    Comic("Comic 2.9", 2021),
                    Comic("Comic 2.10", 2021),
                )
            ),
            Event(
                id = 3,
                title = "Event 3",
                description = "Description for Event 3",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 3.1", 2022),
                    Comic("Comic 3.2", 2023)
                )
            ),
            Event(
                id = 4,
                title = "Event 4",
                description = "Description for Event 4",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 4.1", 2020),
                    Comic("Comic 4.2", 2021),
                    Comic("Comic 4.3", 2021),
                    Comic("Comic 4.4", 2021),
                )
            ),
            Event(
                id = 5,
                title = "Event 5",
                description = "Description for Event 5",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 5.1", 2022),
                    Comic("Comic 5.2", 2023),
                    Comic("Comic 5.3 Lorem ipsum texto de ejemplo", 2023),
                )
            ),
            Event(
                id = 6,
                title = "Event 6",
                description = "Description for Event 6",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 6.1", 2020),
                    Comic("Comic 6.2", 2021)
                )
            ),
            Event(
                id = 7,
                title = "Event 7",
                description = "Description for Event 7",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 7.1", 2022),
                    Comic("Comic 7.2", 2023)
                )
            ),
            Event(
                id = 8,
                title = "Event 8",
                description = "Description for Event 8",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 8.1", 2020),
                    Comic("Comic 8.2", 2021)
                )
            ),
            Event(
                id = 9,
                title = "Event 9",
                description = "Description for Event 9",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 9.1", 2022),
                    Comic("Comic 9.2", 2023)
                )
            ),
            Event(
                id = 10,
                title = "Event 10",
                description = "Description for Event 10",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 10.1", 2020),
                    Comic("Comic 10.2", 2021)
                )
            ),
            Event(
                id = 11,
                title = "Event 11",
                description = "Description for Event 11",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 11.1", 2022),
                    Comic("Comic 11.2", 2023)
                )
            ),
            Event(
                id = 12,
                title = "Event 12",
                description = "Description for Event 12",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 12.1", 2020),
                    Comic("Comic 12.2", 2021)
                )
            ),
            Event(
                id = 13,
                title = "Event 13",
                description = "Description for Event 13",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 13.1", 2022),
                    Comic("Comic 13.2", 2023)
                )
            ),
            Event(
                id = 14,
                title = "Event 14",
                description = "Description for Event 14",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 14.1", 2020),
                    Comic("Comic 14.2", 2021)
                )
            ),
            Event(
                id = 15,
                title = "Event 15",
                description = "Description for Event 15",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = listOf(
                    Comic("Comic 15.1", 2022),
                    Comic("Comic 15.2", 2023)
                )
            )
        )
    }
}
