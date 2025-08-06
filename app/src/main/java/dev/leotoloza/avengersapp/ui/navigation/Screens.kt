package dev.leotoloza.avengersapp.ui.navigation

// En esta clase se definen las pantallas de la aplicación como routes para la navegación.
sealed class Screens(val route: String){
    object Characters: Screens(route = "characters_screen")
    object CharacterDetail: Screens(route = "character_detail_screen")
    object Events: Screens(route = "events_screen")
    object Splash: Screens(route = "splash_screen")
}
