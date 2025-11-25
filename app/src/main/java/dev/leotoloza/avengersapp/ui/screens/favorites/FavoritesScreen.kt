package dev.leotoloza.avengersapp.ui.screens.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.leotoloza.avengersapp.ui.screens.characters.components.CharactersList
import dev.leotoloza.avengersapp.ui.viewmodels.FavoritesViewModel

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel
) {
    val favorites by viewModel.favorites.collectAsState()
    val context = androidx.compose.ui.platform.LocalContext.current

    if (favorites.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "¡Aún no tienes ningún favorito!",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    } else {
        CharactersList(
            charactersList = favorites,
            favorites = favorites,
            isLoadingMore = false,
            onLoadMore = { },
            onToggleFavorite = { character ->
                viewModel.toggleFavorite(character)
            },
            onCharacterClick = { character ->
                android.widget.Toast.makeText(context, character.name, android.widget.Toast.LENGTH_SHORT).show()
            }
        )
    }
}
