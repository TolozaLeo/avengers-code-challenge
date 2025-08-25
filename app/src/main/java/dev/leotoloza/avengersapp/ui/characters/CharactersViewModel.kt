package dev.leotoloza.avengersapp.ui.characters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.model.Comic
import dev.leotoloza.avengersapp.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel
@Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {
    // TODO Implementar uiState con StateFlow
    fun getCharacters(limit: Int, offset: Int): List<Character> { //TODO Eliminar hardcodeo
        viewModelScope.launch {
            val result = getCharactersUseCase(0, 0)
            if (result.isSuccess) {
                Log.d("CharactersViewModel", "Success fetching characters")
            }
            else {
                Log.e("CharactersViewModel", "Error fetching characters")
            }
        }
        return getHardCodedList()
    }

    private fun getHardCodedList(): List<Character> {
        val comics = listOf(
            Comic("Iron Man (1968) #55", 1973),
            Comic("Avengers (1963) #125", 1974),
            Comic("Silver Surfer (1987) #38", 1990),
            Comic("Thanos Quest (1990) #1", 1990)
        )
        val list: List<Character> = listOf(
            Character(
                id = 1,
                name = "Thanos",
                description = "Using the power of the Infinity Stones, Thanos believes he can ultimately save the universe by wiping out half of its population.",
                thumbnailUrl = "https://picsum.photos/300/300",
                comics = comics
            ), Character(
                id = 2,
                name = "Iron Man",
                description = "Tony Stark, un genio multimillonario, utiliza su armadura avanzada para proteger al mundo como Iron Man.",
                thumbnailUrl = "https://picsum.photos/301/300",
                comics = comics
            ), Character(
                id = 3,
                name = "Captain America",
                description = "Steve Rogers, el supersoldado, lucha por la justicia y la libertad como Capitán América.",
                thumbnailUrl = "https://picsum.photos/302/300",
                comics = comics
            ), Character(
                id = 4,
                name = "Thor",
                description = "El dios del trueno de Asgard, portador de Mjolnir y miembro de los Vengadores.",
                thumbnailUrl = "https://picsum.photos/303/300",
                comics = comics
            ), Character(
                id = 5,
                name = "Hulk",
                description = "Bruce Banner se transforma en Hulk, una fuerza imparable de poder y furia.",
                thumbnailUrl = "https://picsum.photos/304/300",
                comics = comics
            ), Character(
                id = 6,
                name = "Black Widow",
                description = "Natasha Romanoff, una espía letal y experta en combate cuerpo a cuerpo.",
                thumbnailUrl = "https://picsum.photos/305/300",
                comics = comics
            ), Character(
                id = 7,
                name = "Hawkeye",
                description = "Clint Barton, el arquero maestro y miembro fundamental de los Vengadores.",
                thumbnailUrl = "https://picsum.photos/306/300",
                comics = comics
            ), Character(
                id = 8,
                name = "Spider-Man",
                description = "Peter Parker, el amistoso vecino Spider-Man, protege Nueva York con sus poderes arácnidos.",
                thumbnailUrl = "https://picsum.photos/307/300",
                comics = comics
            ), Character(
                id = 9,
                name = "Doctor Strange",
                description = "El Hechicero Supremo, maestro de las artes místicas y defensor de la realidad.",
                thumbnailUrl = "https://picsum.photos/308/300",
                comics = comics
            ), Character(
                id = 10,
                name = "Black Panther",
                description = "T'Challa, rey de Wakanda, protege su nación y el mundo como Black Panther.",
                thumbnailUrl = "https://picsum.photos/309/300",
                comics = comics
            ), Character(
                id = 11,
                name = "Scarlet Witch",
                description = "Wanda Maximoff, poderosa usuaria de magia y miembro de los Vengadores.",
                thumbnailUrl = "https://picsum.photos/310/300",
                comics = comics
            )
        )
        return list
    }
}
