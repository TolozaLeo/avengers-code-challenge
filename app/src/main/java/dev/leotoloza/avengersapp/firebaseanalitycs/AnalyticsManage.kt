package dev.leotoloza.avengersapp.firebaseanalitycs


import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AnalyticsManage @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val analytics = FirebaseAnalytics.getInstance(context)

    // ---------- PROPIEDADES DE USUARIO ----------
    fun setUserAge(age: Int) {
        analytics.setUserProperty("edad", age.toString())
    }

    fun setUserNationality(nationality: String) {
        analytics.setUserProperty("nacionalidad", nationality)
    }

    // ---------- EVENTO 1: FAVORITO AGREGADO ----------
    fun logFavoriteAdded(characterId: Int, characterName: String) {
        analytics.logEvent("favorito_agregado") {
            param("character_id", characterId.toLong())
            param("character_name", characterName)
        }
    }

    // ---------- EVENTO 2: PERSONAJE_VISTO ----------
    fun logCharacterViewed(characterId: Int, characterName: String) {
        analytics.logEvent("personaje_visto") {
            param("character_id", characterId.toLong())
            param("character_name", characterName)
        }
    }
}
