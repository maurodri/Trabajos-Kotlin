package com.example.proyecto_login.pages

sealed class Pantallas (val route: String){
    object SplashScreen: Pantallas("splsh_screen")
    object LoginScreen: Pantallas("login_screen")
}