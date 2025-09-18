package dev.leotoloza.avengersapp.ui.screens.events.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.leotoloza.avengersapp.R
import dev.leotoloza.avengersapp.domain.model.Event
import dev.leotoloza.avengersapp.ui.screens.common.ComicCard
import dev.leotoloza.avengersapp.ui.screens.common.createImageRequest

@Composable
fun EventCard(
    event: Event,
) {
    var isExpanded by remember { mutableStateOf(false) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(4.dp),
        onClick = { isExpanded = !isExpanded },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Row(
        ) {
            Box(
                modifier = Modifier.padding(17.dp)
            ) {
                AsyncImage(
                    model = createImageRequest(event.thumbnailUrl),
                    contentDescription = "Event thumbnail",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.img_character_placeholder),
                    modifier = Modifier
                        .size(86.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 15.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    maxLines = 1,
                )
                Text(
                    text = event.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 28.dp, end = 30.dp),
                    color = MaterialTheme.colorScheme.onSecondary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            val arrowIcon = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
            Icon(
                imageVector = arrowIcon,
                tint = Color.Black,
                contentDescription = if (isExpanded) "Colapsar" else "Expandir",
                modifier = Modifier
                    .padding(top = 48.dp, bottom = 48.dp, end = 24.dp)
            )
        }
        AnimatedVisibility(
            visible = isExpanded,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(11.dp))
                Text(
                    text = "COMICS TO DISCUSS",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(14.dp))
                event.comics.forEach { comic ->
                    ComicCard(
                        comicTitle = comic.title, comicYear = comic.year
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun EventCardPreview() {
    EventCard(
        Event(
            id = 1,
            title = "Title",
            description = "Description",
            thumbnailUrl = "https://picsum.photos/86/86",
            comics = emptyList()
        )
    )
}