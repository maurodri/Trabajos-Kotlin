package com.example.dashboard_2.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dashboard_2.pages.Page_Contenidos
import com.example.dashboard_2.pages.Page_Flores
import com.example.dashboard_2.pages.Page_Frutas_Verduras
import com.example.dashboard_2.pages.Page_Huevos
import com.example.dashboard_2.pages.Page_Informacion
import com.example.dashboard_2.pages.Page_Inicio
import com.example.dashboard_2.pages.Page_Lacteos
import com.example.dashboard_2.pages.Page_Principal
import com.example.dashboard_2.pages.Page_Ubicacion
import com.example.dashboard_2.pages.Page_Ver_Mas

// Menu del Drawer
@Composable
fun Navigation_Host(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MenuItem.Page1.ruta
    ) {
        composable(MenuItem.Page1.ruta){
            Page_Principal()
        }
        composable(MenuItem.Page2.ruta){
            Page_Flores()
        }
        composable(MenuItem.Page3.ruta){
            Page_Frutas_Verduras()
        }
        composable(MenuItem.Page4.ruta){
            Page_Huevos()
        }
        composable(MenuItem.Page5.ruta){
            Page_Lacteos()
        }
        composable(MenuItem.Page6.ruta){
            Page_Ver_Mas()
        }
        composable(MenuItem.Page7.ruta){
            Page_Ubicacion()
        }
        composable(items_bar.Boton1.ruta){
            Page_Inicio()
        }
        composable(items_bar.Boton2.ruta){
            Page_Contenidos()
        }
        composable(items_bar.Boton3.ruta){
            Page_Informacion()
        }
    }
}

@Composable
fun Current_Route(navController: NavHostController): String? {
    val  navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}