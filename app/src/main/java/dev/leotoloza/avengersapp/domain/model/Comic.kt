package dev.leotoloza.avengersapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    val title: String,
    val year: Int,
) : Parcelable