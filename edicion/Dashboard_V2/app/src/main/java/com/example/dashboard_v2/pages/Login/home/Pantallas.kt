package com.example.dashboard_v2.pages.Login.home

sealed class Pantallas(val route: String) {
    object SplashScreen: Pantallas("Splash_Screen")
    object Flores: Pantallas("Flores")
    object LogIn: Pantallas("Pantalla_LogIn")

}