package dev.leotoloza.avengersapp.data.remote.mapper

import dev.leotoloza.avengersapp.data.remote.model.Event
import dev.leotoloza.avengersapp.domain.utils.replaceHttpForHttps

fun Event.toDomain(): dev.leotoloza.avengersapp.domain.model.Event{
    val path = this.thumbnail?.path?.replaceHttpForHttps()?: ""
    return dev.leotoloza.avengersapp.domain.model.Event(
        id = this.id?: 0L,
        title = this.title.orEmpty(),
        description = this.description.orEmpty(),
        thumbnailUrl = "$path.${this.thumbnail?.extension}",
        comics = this.comics?.items?.map{ comic ->
            comic.toDomain()
        }?: emptyList()
    )
}