package dev.leotoloza.avengersapp.domain.model

sealed class AppError(message: String) : Exception(message) {

    //    Error de conexión, timeout, o cualquier IOException
    class Network(message: String) : AppError(message)

    //    Error HTTP del lado del cliente (4xx)
    class Client(val code: Int, message: String) : AppError(message)

    //    Error HTTP del lado del servidor (5xx)
    class Server(val code: Int, message: String) : AppError(message)

    //    Error desconocido o inesperado
    class Unknown(message: String) : AppError(message)
}