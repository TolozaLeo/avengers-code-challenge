package dev.leotoloza.avengersapp.ui.characters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.leotoloza.avengersapp.ui.navigation.Screens

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel(),
) {
    val characters = viewModel.getCharacters(20, 0)

    LazyColumn {
        items(characters) { character ->
            CharacterCard(
                character = character,
                onItemClicked = {
                    navController.navigate(Screens.CharacterDetail.route)
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "selectedCharacter", character
                    )
                })
        }
    }
}