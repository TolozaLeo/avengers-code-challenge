package dev.leotoloza.avengersapp.ui.characters

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.ui.common.ComicCard

@Composable
fun CharacterDetailScreen(character: Character) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
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
        items(character.comics) { comic ->
            ComicCard(
                comicTitle = comic.title,
                comicYear = comic.year
            )
        }
        item{
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}