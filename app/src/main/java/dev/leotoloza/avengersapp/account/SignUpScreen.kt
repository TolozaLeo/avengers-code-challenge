package dev.leotoloza.avengersapp.account

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import dev.leotoloza.avengersapp.ui.theme.Black
import dev.leotoloza.avengersapp.ui.theme.White

@Composable
fun SignUpScreen(auth: FirebaseAuth, navigateToInitial: () -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(Black).padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Atrás", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp,
            modifier = Modifier.padding(vertical = 24.dp).clickable{navigateToInitial()}
        )

        Spacer(Modifier.height(48.dp))
        Text("Email", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp)
        TextField(value = email, onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(48.dp))
        Text("Contraseña", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp)
        TextField(value = password, onValueChange = {password = it},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(48.dp))
        Button(onClick = { auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Log.i("signup", "SIGN UP OK")
                navigateToInitial()
            }else{
                Log.i("signup", "SIGN UP ERROR")
            }
        } }) {
            Text(text = "Registrarse")
        }
    }
}