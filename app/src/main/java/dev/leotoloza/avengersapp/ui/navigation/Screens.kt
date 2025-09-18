package dev.leotoloza.avengersapp.ui.navigation

import kotlinx.serialization.Serializable

// En esta clase se definen las pantallas de la aplicación como routes para la navegación.
sealed class Screens(val route: String){
    @Serializable
    object Characters: Screens(route = "characters_screen")

    @Serializable
    object CharacterDetail: Screens(route = "character_detail_screen/{characterId}") {
        fun createRoute(characterId: Int) = "character_detail_screen/$characterId"
        const val NAV_ARG_CHARACTER_ID = "characterId"
    }

    @Serializable
    object Events: Screens(route = "events_screen")
    @Serializable
    object Splash: Screens(route = "splash_screen")
}
