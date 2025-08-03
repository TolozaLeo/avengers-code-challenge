package dev.leotoloza.avengersapp.ui.common

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.leotoloza.avengersapp.R
import dev.leotoloza.avengersapp.ui.navigation.Screens

data class BottomNavItem(
    val route: String,
    val iconResSelected: Int,
    val iconResUnselected: Int,
    val contentDescription: String
)

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackStackEntry?.destination?.route

    val navItems = listOf(
        BottomNavItem(
            route = Screens.Characters.route,
            iconResSelected = R.drawable.ic_superhero_enabled,
            iconResUnselected = R.drawable.ic_superhero_disabled,
            contentDescription = "Characters"
        ),
        BottomNavItem(
            route = Screens.Events.route,
            iconResSelected = R.drawable.ic_calendar_enabled,
            iconResUnselected = R.drawable.ic_calendar_disabled,
            contentDescription = "Events"
        )
    )

    //TODO Crear una custom bottomBar para modificar la altura (tiene que tener 56.dp)
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        tonalElevation = 0.dp,
    ) {
        navItems.forEach { item ->

            val isSelected = item.route == currentDestination

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if(!isSelected) {
                        navController.navigate(item.route)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected) item.iconResSelected else item.iconResUnselected
                        ),
                        contentDescription = item.contentDescription,
                        tint = Color.Unspecified // Se respeta el color del recurso
                    )
                },
                label = { Text(text = item.contentDescription) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Unspecified,
                    unselectedIconColor = Color.Unspecified,
                    selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                    unselectedTextColor = MaterialTheme.colorScheme.inverseOnSurface,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}