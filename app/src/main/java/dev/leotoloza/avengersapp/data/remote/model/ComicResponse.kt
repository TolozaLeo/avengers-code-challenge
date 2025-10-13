package dev.leotoloza.avengersapp.data.remote.model

import com.squareup.moshi.Json

data class ComicResponse(
    @Json(name = "items") var items: List<ComicItem>,
)

data class ComicItem(
    @Json(name = "name") var name: String?,
)