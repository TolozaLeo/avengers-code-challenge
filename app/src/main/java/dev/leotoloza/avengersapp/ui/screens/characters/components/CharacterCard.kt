package dev.leotoloza.avengersapp.ui.screens.characters.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.leotoloza.avengersapp.R
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.ui.screens.common.createImageRequest

@Composable
fun CharacterCard(
    character: Character,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onItemClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(horizontal = 4.5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(4.dp),
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
                    model = createImageRequest(character.thumbnailUrl),
                    contentDescription = "Character thumbnail",
                    contentScale = ContentScale.Fit,
                    placeholder = painterResource(R.drawable.img_character_placeholder),
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = character.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .weight(1f),
                        color = MaterialTheme.colorScheme.onPrimary,
                        maxLines = 1,
                    )
                    IconButton(onClick = onFavoriteClick) {
                        val scale by animateFloatAsState(
                            targetValue = if (isFavorite) 1.2f else 1.0f,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            ),
                            label = "scale"
                        )
                        val color by animateColorAsState(
                            targetValue = if (isFavorite) Color.Red else MaterialTheme.colorScheme.onPrimary,
                            label = "color"
                        )

                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = color,
                            modifier = Modifier.scale(scale)
                        )
                    }
                }
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