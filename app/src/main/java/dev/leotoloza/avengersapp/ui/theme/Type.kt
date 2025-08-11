package dev.leotoloza.avengersapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.leotoloza.avengersapp.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal)
)

val RobotoCondensed = FontFamily(
    Font(R.font.roboto_condensed, FontWeight.Normal)
)

val RobotoCondensedBold = FontFamily(
    Font(R.font.roboto_condensed_bold, FontWeight.Bold)
)

val Typography = Typography(
    // 1- Título de la app
    headlineLarge = TextStyle(
        fontFamily = RobotoCondensedBold,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 26.sp,
        color = White
    ),
    // 2- Título de cada elemento en una lista
    titleLarge = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        color = Title
    ),
    // 3- Descripción de cada elemento de la lista
    bodyMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        color = Subtitle
    ),
    // 4- Nombre de elementos en la navigationBar
    labelSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    )
)