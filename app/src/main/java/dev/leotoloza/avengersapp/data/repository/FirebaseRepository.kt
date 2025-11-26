package dev.leotoloza.avengersapp.data.repository

import android.util.Log
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject

class FirebaseRepository @Inject constructor(
    private val db: FirebaseFirestore
) {

    fun addFavorite(userId: String, characterId: Int, characterName: String) {
        val favDoc = hashMapOf(
            "userId" to userId,
            "characterId" to characterId,
            "characterName" to characterName,
            "createdAt" to Timestamp.now()
        )

        db.collection("favorites").add(favDoc)
            .addOnSuccessListener { docRef ->
                Log.d("FAVORITE", "Favorito guardado: ${docRef.id}")
            }
            .addOnFailureListener { e ->
                Log.w("FAVORITE", "Error al guardar favorito", e)
            }
    }
}