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
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EventsScreen(
    viewModel: EventsViewModel = hiltViewModel(),
) {
    val events = viewModel.getEvents(0,0)
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