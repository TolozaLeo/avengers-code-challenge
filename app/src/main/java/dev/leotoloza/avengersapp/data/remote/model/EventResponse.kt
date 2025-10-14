package dev.leotoloza.avengersapp.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class EventsResponse(
    @Json(name = "data") val data: DataEvent
)

@JsonClass(generateAdapter = true)
data class DataEvent(
    @Json(name = "results") val results: List<Event>
)

@JsonClass(generateAdapter = true)
data class Event(
    @Json(name = "id") val id: Long?,
    @Json(name = "title") val title: String?,
    @Json(name = "start") val startDate: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "comics") val comics: ComicResponse?,
    @Json(name = "thumbnail") val thumbnail: Thumbnail?
)