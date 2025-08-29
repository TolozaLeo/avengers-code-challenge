package dev.leotoloza.avengersapp.ui.characters

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
import androidx.navigation.NavController
import dev.leotoloza.avengersapp.ui.navigation.Screens

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel(),
) {
    val characters = viewModel.getCharacters(20, 0)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.5.dp, start = 3.5.dp,end = 3.5.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items(characters) { character ->
            CharacterCard(
                character = character, onItemClicked = {
                    navController.navigate(Screens.CharacterDetail.route)
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "selectedCharacter", character
                    )
                })
        }
    }
}