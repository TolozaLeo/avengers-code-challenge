package dev.leotoloza.avengersapp.data.remote.mapper

import dev.leotoloza.avengersapp.data.remote.model.CharacterItem
import dev.leotoloza.avengersapp.domain.model.Comic

fun CharacterItem.toDomain(): dev.leotoloza.avengersapp.domain.model.Character{
    return dev.leotoloza.avengersapp.domain.model.Character(
        id = this.id ?: 0,
        name = this.name.orEmpty(),

        // ¡PROBLEMA! La API de Disney no provee 'description' en la lista.
        description = "",

        // La URL de la imagen está OK
        thumbnailUrl = this.thumbnail.orEmpty(),

        // ¡PROBLEMA! La UI espera una Lista<Comic> (con id, title, imageUrl).
        // La API de Disney solo da una Lista<String> con nombres de películas.
        // se tienen que "fabricar" objetos Comic a partir de los strings de 'films' y 'tvShows'.
        comics = (this.films + this.tvShows).mapIndexed { index, filmName ->
            Comic(
                title = filmName,
                year=  index.toString(),
            )
        }
    )
}
