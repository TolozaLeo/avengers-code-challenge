package dev.leotoloza.avengersapp.ui.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.leotoloza.avengersapp.R
import dev.leotoloza.avengersapp.domain.model.Character

@Composable
fun CharacterCard(
    character: Character,
    onItemClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .height(120.dp)
            .fillMaxWidth()
            .padding(top = 9.dp, start = 8.dp, end = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.5.dp),
        onClick = onItemClicked
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(120.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(character.thumbnailUrl)
                        .crossfade(true).build(),
                    contentDescription = "Character thumbnail",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.img_thanos), //TODO CAMBIAR PLACEHOLDER
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 15.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    maxLines = 1,
                )
                Text(
                    text = character.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 28.dp, end = 30.dp),
                    color = MaterialTheme.colorScheme.onSecondary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}