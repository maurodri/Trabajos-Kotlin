package com.example.dashboard_v2.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dashboard_v2.R
import com.example.dashboard_v2.data.Recipe
import com.example.dashboard_v2.data.strawberryCake
import com.example.dashboard_v2.pages.Carrito
import com.example.dashboard_v2.pages.Item
import com.example.dashboard_v2.pages.MainFragment
import com.example.dashboard_v2.pages.Page_Contenidos
import com.example.dashboard_v2.pages.Page_Flores
import com.example.dashboard_v2.pages.Page_Frutas_Verduras
import com.example.dashboard_v2.pages.Page_Huevos
import com.example.dashboard_v2.pages.Page_Inicio
import com.example.dashboard_v2.pages.Page_Lacteos
import com.example.dashboard_v2.pages.Page_Ubicacion
import com.example.dashboard_v2.pages.WeatherView
import com.example.dashboard_v2.pages.Productos
import com.google.accompanist.pager.ExperimentalPagerApi

// Menu del Drawer

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Navigation_Host(navController: NavHostController, cartItems: MutableState<List<Item>>) {
    NavHost(
        navController = navController,
        startDestination = MenuItem.Page1.ruta
    ) {
        composable(MenuItem.Page1.ruta){
            MainFragment(navController)
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
            WeatherView()
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

        composable(items_bar.Boton3.ruta) {
            Productos { item ->
                cartItems.value = cartItems.value + item
            }
        }
        composable("carrito") {
            Carrito(cartItems.value) { item ->
                cartItems.value = cartItems.value - item
            }

        }

    }
}

@Composable
fun Current_Route(navController: NavHostController): String? {
    val  navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}
