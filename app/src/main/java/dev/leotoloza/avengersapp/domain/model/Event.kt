package dev.leotoloza.avengersapp.domain.model
//TODO HACER QUE SEA PARCELABLE
data class Event (
    val id : Int,
    val title : String,
    val description : String,
    val thumbnailUrl: String,
    val comics: List<Comic>,
)