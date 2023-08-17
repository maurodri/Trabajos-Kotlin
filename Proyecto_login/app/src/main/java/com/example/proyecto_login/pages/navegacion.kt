package com.example.proyecto_login.pages

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_login.pages.login.LoginScreen

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Pantallas.SplashScreen.route){
        composable(Pantallas.SplashScreen.route){
            SplahsScreen(navController)
        }
        composable(Pantallas.LoginScreen.route){
            LoginScreen()
        }
    }
}