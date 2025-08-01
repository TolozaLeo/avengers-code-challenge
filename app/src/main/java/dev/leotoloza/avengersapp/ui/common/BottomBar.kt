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
import dev.leotoloza.avengersapp.R

data class BottomNavItem(
    val route: String,
    val iconResSelected: Int,
    val iconResUnselected: Int,
    val contentDescription: String
)

@Composable
fun BottomBar(
//    navController: NavHostController,
) {
    val navItems = listOf(
        BottomNavItem(
            route = "Characters",
            iconResSelected = R.drawable.ic_superhero_enabled,
            iconResUnselected = R.drawable.ic_superhero_disabled,
            contentDescription = "CharactersScreen"
        ),
        BottomNavItem(
            route = "Events",
            iconResSelected = R.drawable.ic_calendar_enabled,
            iconResUnselected = R.drawable.ic_calendar_disabled,
            contentDescription = "EventsScreen"
        )
    )
    // TODO Agregar toda la locica de navegacion

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        tonalElevation = 1.dp,
    ) {
        navItems.forEach { item ->

            val isSelected = item.route == "Characters" // TODO: implementar lógica de selección real con route actual

            NavigationBarItem(
                selected = isSelected,
                onClick = { /* TODO manejar navegacion entre pantallas */ },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected) item.iconResSelected else item.iconResUnselected
                        ),
                        contentDescription = item.contentDescription,
                        tint = Color.Unspecified // Se respeta el color del recurso
                    )
                },
                label = { Text(text = item.route) },
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