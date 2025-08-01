package dev.leotoloza.avengersapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = White,
    secondary = DarkGrey,
    background = Gray,
    onPrimary = Title,
    onSecondary = Subtitle,
    onTertiary = Description,
    inverseOnSurface = Unselected,
)

private val LightColorScheme = lightColorScheme(
    primary = White,
    secondary = DarkGrey,
    background = Gray,
    onPrimary = Title,
    onSecondary = Subtitle,
    onTertiary = Description,
    inverseOnSurface = Unselected,
)

@Composable
fun AvengersAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if(darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}