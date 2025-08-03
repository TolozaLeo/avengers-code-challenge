package dev.leotoloza.avengersapp.ui.navigation

// En esta clase se definen las pantallas de la aplicación como routes para la navegación.
sealed class Screens(val route: String){
    object characters: Screens(route = "characters_screen")
    object characterDetail: Screens(route = "character_detail_screen")
    object events: Screens(route = "events_screen")
}
