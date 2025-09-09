package dev.leotoloza.avengersapp.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.leotoloza.avengersapp.R
import dev.leotoloza.avengersapp.ui.navigation.Screens
import dev.leotoloza.avengersapp.ui.navigation.CHARACTERS_GRAPH_ROUTE // Import CHARACTERS_GRAPH_ROUTE
import dev.leotoloza.avengersapp.ui.navigation.MAIN_APP_GRAPH_ROUTE // Import MAIN_APP_GRAPH_ROUTE

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
    val currentRoute = navBackStackEntry?.destination?.route

    val navItems = listOf(
        BottomNavItem(
            route = CHARACTERS_GRAPH_ROUTE, // ruta de charactersGraph
            iconResSelected = R.drawable.ic_superhero_enabled,
            iconResUnselected = R.drawable.ic_superhero_disabled,
            contentDescription = "Characters"
        ), BottomNavItem(
            route = Screens.Events.route, // ruta de eventsScreen
            iconResSelected = R.drawable.ic_calendar_enabled,
            iconResUnselected = R.drawable.ic_calendar_disabled,
            contentDescription = "Events"
        )
    )

    // Determina si la bottomBar debe ser visible.
    val isVisible = navItems.any { item ->
        currentRoute == item.route ||
                (item.route == CHARACTERS_GRAPH_ROUTE && currentRoute == Screens.Characters.route)
    }

    AnimatedVisibility(
        visible = isVisible, enter = fadeIn(), exit = fadeOut()
    ) {
        Box(
            modifier = Modifier.shadow(8.dp)
        ) {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary,
            ) {
                navItems.forEach { item ->
                    val isSelected =
                        currentRoute == item.route || (item.route == CHARACTERS_GRAPH_ROUTE && currentRoute == Screens.Characters.route)

                    NavigationBarItem(
                        selected = isSelected, onClick = {
                        if (!isSelected) {
                            navController.navigate(item.route) {
                                popUpTo(MAIN_APP_GRAPH_ROUTE) { // Pop up hasta inicio del main graph
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }, icon = {
                        Icon(
                            painter = painterResource(
                                id = if (isSelected) item.iconResSelected else item.iconResUnselected
                            ),
                            contentDescription = item.contentDescription,
                            tint = Color.Unspecified
                        )
                    }, label = {
                        Text(
                            text = item.contentDescription,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }, colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Unspecified,
                        unselectedIconColor = Color.Unspecified,
                        selectedTextColor = MaterialTheme.colorScheme.secondary,
                        unselectedTextColor = MaterialTheme.colorScheme.inverseOnSurface,
                        indicatorColor = Color.Transparent
                    )
                    )
                }
            }
        }
    }
}
