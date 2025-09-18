package dev.leotoloza.avengersapp.ui.screens.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest

@Composable
fun createImageRequest(url: String): ImageRequest =
    ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build()