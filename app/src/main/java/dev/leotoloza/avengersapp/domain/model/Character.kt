package dev.leotoloza.avengersapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailUrl: String,
    val comics: List<Comic>,
) : Parcelable