package dev.leotoloza.avengersapp.domain.model

//TODO HACER QUE SEA PARCELABLE
data class Hero (
    val id : Int,
    val name : String,
    val description : String,
    val thumbnailUrl: String,
    val comics: List<Comic>,
)