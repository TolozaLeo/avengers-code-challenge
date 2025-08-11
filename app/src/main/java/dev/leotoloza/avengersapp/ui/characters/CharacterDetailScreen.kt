package dev.leotoloza.avengersapp.ui.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.leotoloza.avengersapp.domain.model.Comic

//  TODO Pasar por parametro el personaje
@Composable
fun CharacterDetailScreen() {
    val comics = listOf(
        Comic("Iron Man (1968) #55", 1973),
        Comic("Avengers (1963) #125", 1974),
        Comic("Silver Surfer (1987) #38", 1990),
        Comic("Thanos Quest (1990) #1", 1990)
    )
    val character = dev.leotoloza.avengersapp.domain.model.Character(
        id = 1,
        name = "Thanos",
        description = "Using the power of the Infinity Stones, Pepe believes he can ultimately save the universe by wiping out half of its population.",
        thumbnailUrl = "https://picsum.photos/300/300",
        comics = comics
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AsyncImage(
                model = character.thumbnailUrl,
                contentDescription = "Character image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(21.dp))
            Text(
                text = character.description,
                color = MaterialTheme.colorScheme.onTertiary,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 52.dp)
            )
            Spacer(modifier = Modifier.height(43.dp))
            Text(
                text = "APPEARS IN THESE COMICS",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(14.dp))
        }

        items(comics) { comic ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(88.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = comic.title,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = comic.year.toString(),
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(top = 16.dp),
                        thickness = DividerDefaults.Thickness,
                        color = Color.Black.copy(alpha = 0.2f)
                    )
                }
            }
        }
    }
}