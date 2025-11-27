package dev.leotoloza.avengersapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import dev.leotoloza.avengersapp.account.LoginScreen
import dev.leotoloza.avengersapp.account.SignUpScreen
import dev.leotoloza.avengersapp.ui.screens.MainScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHostController, startDestination = "initial"){
        composable("initial"){
            InitialScreen(
                navigateToLogin = {navHostController.navigate("logIn")},
                navigateToSignUp = {navHostController.navigate("signUp")}
            )
        }
        composable("logIn"){
            LoginScreen(auth, navigateToInitial = {navHostController.navigate("initial")},
                        navigateToMain = {navHostController.navigate("main")})
        }
        composable("signUp"){
            SignUpScreen(auth, navigateToInitial = {navHostController.navigate("initial")})
        }
        composable("main"){
            MainScreen()
        }
    }
}