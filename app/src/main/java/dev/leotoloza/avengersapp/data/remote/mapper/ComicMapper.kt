package dev.leotoloza.avengersapp.data.remote.mapper

import dev.leotoloza.avengersapp.data.remote.model.ComicItem
import dev.leotoloza.avengersapp.domain.model.Comic
import dev.leotoloza.avengersapp.domain.utils.findBetweenParenthesis

fun ComicItem.toDomain(): Comic {
    return Comic(
        title = this.name.orEmpty(),
        year = this.name?.findBetweenParenthesis()?:""
    )
}