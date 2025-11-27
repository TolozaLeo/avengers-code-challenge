package dev.leotoloza.avengersapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
@Parcelize
data class Comic(
    val title: String = "",
    val year: String = "",
) : Parcelable