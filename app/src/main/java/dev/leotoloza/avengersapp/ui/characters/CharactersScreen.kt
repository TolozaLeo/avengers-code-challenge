package dev.leotoloza.avengersapp.ui.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CharactersScreen(
//    viewModel: CharactersViewModel = hiltViewModel()
//    onItemClicked: (Character) -> Unit = {  }
    onItemClicked: () -> Unit = { }
) {
    LazyColumn {
        items(20) { index ->
            CharacterCard(
                characterName = "Character ${index + 1}", onItemClicked = onItemClicked
            )
        }
    }
}

@Preview
@Composable
fun CharactersScreenPreview() {
    CharactersScreen(onItemClicked = {})
}