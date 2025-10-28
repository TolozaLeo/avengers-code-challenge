package dev.leotoloza.avengersapp.ui.utils

import android.app.Application
import dev.leotoloza.avengersapp.R
import dev.leotoloza.avengersapp.domain.model.AppError
import jakarta.inject.Inject
import javax.inject.Singleton

/**
 * Traduce un Throwable (específicamente nuestro AppError)
 * al ID de recurso de String correspondiente.
 */
@Singleton
class UiErrorProvider @Inject constructor(
    private val app: Application // Inyectamos Application para tener Context
) {
    fun getErrorMessage(exception: Throwable): String {
        return when (exception) {
            is AppError.Network -> app.getString(R.string.error_bad_connection)
            is AppError.Client -> when (exception.code) {
                400 -> app.getString(R.string.error_bad_request)
                403 -> app.getString(R.string.error_forbidden)
                408 -> app.getString(R.string.error_request_time_out)
                else -> app.getString(R.string.generic_error)
            }
            is AppError.Server -> when (exception.code) {
                500 -> app.getString(R.string.error_internal_server_error)
                503 -> app.getString(R.string.error_service_unavailable)
                else -> app.getString(R.string.generic_error)
            }
            else -> app.getString(R.string.generic_error) // Para AppError.Unknown
        }
    }
}