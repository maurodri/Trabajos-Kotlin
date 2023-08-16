package com.example.dashboard_v2.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_v2.data.Recipe
import com.example.dashboard_v2.pages.Item
import com.example.dashboard_v2.ui.theme.Dashboard_V2Theme

@Composable
fun MainPage() {
    val cartItems = remember { mutableStateOf(listOf<Item>()) }
    val navController = rememberNavController()
//    ScaffoldState: guarda el estado permitiendo conocer la configuracion
    val scaffoldState = rememberScaffoldState()
//    scope: utilizada para abrir/cerrar el drawer
    val scope = rememberCoroutineScope()

//    opciones de navegacion del Drawer
    val navigationItems = listOf(
        MenuItem.Page1,
        MenuItem.Page2,
        MenuItem.Page3,
        MenuItem.Page4,
        MenuItem.Page5,
        MenuItem.Page6,
        MenuItem.Page7
    )
//    opciones de navegacion del bottomBar
    val navigationItemsBottomBar = listOf(
        items_bar.Boton1,
        items_bar.Boton2,
        items_bar.Boton3,
        )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                scope,
                scaffoldState,
                navController,
                navigationItems
            )
        },
        drawerContent = {
            DrawerMenu(
                scope,
                scaffoldState,
                navController,
                menu_items = navigationItems
            )
        },
        bottomBar = {
            BottomMenu(
                navController,
                menu_items_bar = navigationItemsBottomBar
            )
        },
        floatingActionButton = {
            Fab(
                scope,
                scaffoldState,
                navController,
                cartItems.value
            )
        },
        isFloatingActionButtonDocked = true
    )
    { padding ->
        ContentScaffold(
            padding = padding
        )
        Navigation_Host(navController, cartItems)
    }
}

@Composable
fun ContentScaffold(padding: PaddingValues) {
}




