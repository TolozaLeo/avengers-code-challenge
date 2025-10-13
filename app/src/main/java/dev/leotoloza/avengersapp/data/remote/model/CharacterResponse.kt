package dev.leotoloza.avengersapp.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CharactersResponse(
    @Json(name = "data") var data: Data
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "results") var results: List<CharacterItem>
)

@JsonClass(generateAdapter = true)
data class CharacterItem(
    @Json(name = "id") var id: Long?,
    @Json(name = "name") var name: String?,
    @Json(name = "description") var description: String?,
    @Json(name = "thumbnail") var thumbnail: Thumbnail?,
    @Json(name = "comics") var comics: ComicResponse?
)

@JsonClass(generateAdapter = true)
data class Thumbnail(
    @Json(name = "path") val path: String?, @Json(name = "extension") val extension: String?
)
