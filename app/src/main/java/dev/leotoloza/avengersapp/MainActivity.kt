package dev.leotoloza.avengersapp

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import dagger.hilt.android.AndroidEntryPoint
import dev.leotoloza.avengersapp.ui.screens.MainScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            askNotificationPermission()
            MainScreen()
        }
    }

    private val requestNotificationPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                // El usuario aceptó → ya puedes recibir y mostrar notificaciones
            } else {
                // El usuario rechazó → manejar el caso
            }
        }

    fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
}