package dev.leotoloza.avengersapp.ui.events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.leotoloza.avengersapp.domain.model.Comic
import dev.leotoloza.avengersapp.domain.model.Event
import kotlin.collections.listOf

//TODO Hacer uso del viewmodel para obtener los eventos
@Composable
fun EventsScreen() {
    val events = listOf(
        Event(
            id = 1,
            title = "Title",
            description = "Description",
            thumbnailUrl = "https://picsum.photos/86/86",
            comics = listOf(
                Comic("Iron Man (1968) #55", 1973),
                Comic("Avengers (1963) #125", 1974),
                Comic("Silver Surfer (1987) #38", 1990),
                Comic("Thanos Quest (1990) #1", 1990)
            )
        ),
        Event(
            id = 1,
            title = "Title",
            description = "Description",
            thumbnailUrl = "https://picsum.photos/86/86",
            comics = emptyList()
        ),
        Event(
            id = 1,
            title = "Title",
            description = "Description",
            thumbnailUrl = "https://picsum.photos/86/86",
            comics = emptyList()
        ),
        Event(
            id = 1,
            title = "Title",
            description = "Description",
            thumbnailUrl = "https://picsum.photos/86/86",
            comics = emptyList()
        ),
        Event(
            id = 1,
            title = "Title",
            description = "Description",
            thumbnailUrl = "https://picsum.photos/86/86",
            comics = emptyList()
        ),
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.5.dp, start = 3.5.dp, end = 3.5.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items(events) { event ->
            EventCard(event)
        }
    }

}