package dev.leotoloza.avengersapp.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CharactersResponse<T>(
    @Json(name = "data") var data: List<T>,
    @Json(name = "info") var info: Data
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "count") var count: Int,
    @Json(name = "totalPages") var totalPages: Int,
    @Json(name = "nextPage") var nextPage: String?,
    @Json(name = "previousPage") var previousPage: String?,
)

@JsonClass(generateAdapter = true)
data class CharacterItem(
    @Json(name = "_id") var id: Long?,
    @Json(name = "name") var name: String?,
    @Json(name = "description") var description: String?,
    @Json(name = "imageUrl") var thumbnail: String?,
    @Json(name = "films") var films: List<String>,
    @Json(name = "tvShows") var tvShows: List<String>,
)

//    @Json(name = "comics") var comics: ComicResponse?

@JsonClass(generateAdapter = true)
data class Thumbnail(
    @Json(name = "path") val path: String?, @Json(name = "extension") val extension: String?
)
