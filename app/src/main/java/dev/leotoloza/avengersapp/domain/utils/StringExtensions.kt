package dev.leotoloza.avengersapp.domain.utils

fun String.replaceHttpForHttps(): String {
    return replace("http://", "https://")
}

fun String.findBetweenParenthesis(): String {
    return substringAfter("(").substringBefore(')')
}