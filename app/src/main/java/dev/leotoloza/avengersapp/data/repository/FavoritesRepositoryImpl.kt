package dev.leotoloza.avengersapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import dev.leotoloza.avengersapp.domain.model.Character
import dev.leotoloza.avengersapp.domain.repository.FavoritesRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : FavoritesRepository {

    private val favoritesCollection = firestore.collection("favorites")

    override suspend fun toggleFavorite(character: Character) {
        val document = favoritesCollection.document(character.id.toString())
        val snapshot = document.get().await()
        if (snapshot.exists()) {
            document.delete().await()
        } else {
            document.set(character, SetOptions.merge()).await()
        }
    }

    override fun getFavorites(): Flow<List<Character>> = callbackFlow {
        val subscription = favoritesCollection.addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                val characters = snapshot.toObjects(Character::class.java)
                trySend(characters)
            }
        }
        awaitClose { subscription.remove() }
    }

    override suspend fun isFavorite(characterId: Long): Boolean {
        val document = favoritesCollection.document(characterId.toString()).get().await()
        return document.exists()
    }
}
