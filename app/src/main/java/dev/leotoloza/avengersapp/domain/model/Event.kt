package dev.leotoloza.avengersapp.domain.model

data class Event (
    val id : Int,
    val title : String,
    val description : String,
    val thumbnailUrl: String,
    val comics: List<Comic>,
)