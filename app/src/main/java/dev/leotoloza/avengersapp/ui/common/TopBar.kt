package dev.leotoloza.avengersapp.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.leotoloza.avengersapp.R
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavController
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackStackEntry?.destination?.route

    val showBackButton = currentDestination == Screens.CharacterDetail.route

    val character = navBackStackEntry?.savedStateHandle?.get<Character>("selectedCharacter")

    AnimatedVisibility(
        visible = true, enter = fadeIn(), exit = fadeOut()
    ) {
        CenterAlignedTopAppBar(
            title = {
            val tittleText =
                if (currentDestination == Screens.CharacterDetail.route && character != null)
                    character.name.uppercase()
                else stringResource(R.string.marvel_challenge)
            Text(
                text = tittleText,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }, navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = {
                    navController.navigate(Screens.Characters.route)
                }) {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = "Atrás",
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            titleContentColor = MaterialTheme.colorScheme.onSecondary,
            navigationIconContentColor = MaterialTheme.colorScheme.onSecondary
        )
        )
    }
}
