package com.example.dashboard_v2.pages.Login.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_v2.components.MainPage
import com.example.dashboard_v2.components.MenuItem
import com.example.dashboard_v2.data.Recipe
import com.example.dashboard_v2.pages.Login.LoginScreen
import com.example.dashboard_v2.pages.Login.animations.SplashScreen
import com.example.dashboard_v2.pages.Page_Flores

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Pantallas.SplashScreen.route) {
        composable(Pantallas.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Pantallas.LogIn.route) {
            LoginScreen(navController)
        }
        composable(route = MenuItem.Page1.ruta){
            MainPage()
        }

    }
}

@Composable
fun Navegacion2() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Pantallas.SplashScreen.route) {
        composable(Pantallas.Flores.route) {
            Page_Flores()
        }

    }
}