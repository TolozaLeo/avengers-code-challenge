package dev.leotoloza.avengersapp.domain.model

import android.os.Parcelable
import com.google.firebase.firestore.IgnoreExtraProperties
import kotlinx.parcelize.Parcelize

@IgnoreExtraProperties
@Parcelize
data class Character(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val thumbnailUrl: String = "",
    val comics: List<Comic> = emptyList(),
) : Parcelable
