package dev.leotoloza.avengersapp.data.remote

import dev.leotoloza.avengersapp.domain.model.AppError
import jakarta.inject.Inject
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException

class ErrorHandler @Inject constructor() {
    fun getError(exception: Throwable): AppError {
        return when (exception) {
            // Errores de Red
            is IOException, is ConnectException, is SocketTimeoutException -> {
                AppError.Network("Error de Red")
            }
            // Errores HTTP
            is HttpException -> {
                val code = exception.code()
                if (code in 400..499) {
                    // Errores de Cliente (400..499)
                    AppError.Client(code, "Error de Cliente $code")
                } else {
                    // Errores de Servidor (500..599)
                    AppError.Server(code, "Error de Servidor $code")
                }
            }
            // Error Desconocido
            else -> {
                AppError.Unknown(exception.message ?: "Error desconocido")
            }
        }
    }
}