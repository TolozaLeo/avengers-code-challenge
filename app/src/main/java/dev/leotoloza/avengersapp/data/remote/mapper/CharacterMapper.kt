package dev.leotoloza.avengersapp.data.remote.mapper

import dev.leotoloza.avengersapp.data.remote.model.CharacterItem
import dev.leotoloza.avengersapp.ui.utils.replaceHttpForHttps

fun CharacterItem.toDomain(): dev.leotoloza.avengersapp.domain.model.Character{
    val path = this.thumbnail?.path?.replaceHttpForHttps()
    return dev.leotoloza.avengersapp.domain.model.Character(
        id = this.id ?: 0L,
        name = this.name.orEmpty(),
        description = this.description.orEmpty(),
        thumbnailUrl = "$path.${this.thumbnail?.extension}",
        comics = this.comics?.items?.map{ comic ->
            comic.toDomain()
        } ?: emptyList()
    )
}