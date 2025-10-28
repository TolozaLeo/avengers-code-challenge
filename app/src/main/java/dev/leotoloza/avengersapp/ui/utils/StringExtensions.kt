package dev.leotoloza.avengersapp.ui.utils

fun String.replaceHttpForHttps(): String {
    return replace("http://", "https://")
}

fun String.findBetweenParenthesis(): String {
    return substringAfter("(").substringBefore(')')
}