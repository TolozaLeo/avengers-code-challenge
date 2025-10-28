package dev.leotoloza.avengersapp.data.remote.mapper

import dev.leotoloza.avengersapp.data.remote.model.Event
import dev.leotoloza.avengersapp.ui.utils.replaceHttpForHttps
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun formatMarvelDate(dateString: String?): String {
    if (dateString.isNullOrEmpty()) {
        return ""
    }

    return try {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val dateTime = LocalDateTime.parse(dateString, inputFormatter)
        val outputFormatter = DateTimeFormatter.ofPattern(
            "d 'de' MMMM yyyy", java.util.Locale("es", "ES")
        )
        dateTime.format(outputFormatter)
    } catch (e: Exception) {
        // En caso de que la fecha venga en un formato inesperado,
        // devuelve vacío para no crashear la app.
        ""
    }
}

fun Event.toDomain(): dev.leotoloza.avengersapp.domain.model.Event {
    val path = this.thumbnail?.path?.replaceHttpForHttps() ?: ""
    return dev.leotoloza.avengersapp.domain.model.Event(
        id = this.id ?: 0L,
        title = this.title.orEmpty(),
        startDate = formatMarvelDate(this.startDate),
        description = this.description.orEmpty(),
        thumbnailUrl = "$path.${this.thumbnail?.extension}",
        comics = this.comics?.items?.map { comic ->
            comic.toDomain()
        } ?: emptyList())
}