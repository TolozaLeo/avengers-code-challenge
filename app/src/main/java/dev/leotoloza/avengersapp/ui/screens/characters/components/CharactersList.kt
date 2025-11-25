package dev.leotoloza.avengersapp.ui.screens.characters.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.leotoloza.avengersapp.domain.model.Character
import kotlinx.coroutines.flow.filter

@Composable
fun CharactersList(
    charactersList: List<Character>,
    favorites: List<Character>,
    isLoadingMore: Boolean,
    onLoadMore: () -> Unit,
    onToggleFavorite: (Character) -> Unit,
    onCharacterClick: (Character) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.5.dp, start = 3.5.dp, end = 3.5.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items(charactersList) { character ->
            CharacterCard(
                character = character,
                isFavorite = favorites.any { it.id == character.id },
                onFavoriteClick = { onToggleFavorite(character) },
                onItemClicked = { onCharacterClick(character) })
        }
        if (isLoadingMore) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(36.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 4.dp
                    )
                }
            }
        }
    }
//    Efecto que se dispara cuando cambia el estado del scroll
    LaunchedEffect(listState) {
//        snapshotFlow convierte el estado de la lista en un Flow de Kotlin observable.
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .filter { lastVisibleItemIndex ->
                // Llama solo si la condición es verdadera
                lastVisibleItemIndex != null && lastVisibleItemIndex >= charactersList.size - 5
            }
            .collect {
                // Cuando la condición se cumple, llama para cargar más
                onLoadMore()
            }
    }
}