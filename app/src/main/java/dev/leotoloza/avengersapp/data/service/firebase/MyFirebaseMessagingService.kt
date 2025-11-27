package dev.leotoloza.avengersapp.data.service.firebase


import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {


    override fun onNewToken(token: String) {
        super.onNewToken(token)


        FirebaseMessaging.getInstance()
            .subscribeToTopic("favorites")
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        showNotification(message)
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private fun showNotification(message: RemoteMessage) {
        val channelId = "favorites_channel"

        val channel = NotificationChannel(
            channelId,
            "Favoritos",
            NotificationManager.IMPORTANCE_HIGH
        )
        getSystemService(NotificationManager::class.java)
            .createNotificationChannel(channel)

        val title = message.notification?.title ?: "Nuevo favorito"
        val body = message.notification?.body ?: "Se agregó un personaje a favoritos"

        val builder = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        NotificationManagerCompat.from(this).notify(
            System.currentTimeMillis().toInt(),
            builder.build()
        )
    }
}