package com.example.dashboard_2.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_2.ui.theme.Dashboard_2Theme
import com.example.dashboard_2.components.BottomMenu
import com.example.dashboard_2.components.DrawerMenu
import com.example.dashboard_2.components.Fab
import com.example.dashboard_2.components.MenuItem
import com.example.dashboard_2.components.Navigation_Host
import com.example.dashboard_2.components.TopBar

@Composable
fun MainPage() {
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
                scaffoldState
            )
        },
        isFloatingActionButtonDocked = true
    )
    { padding ->
        ContentScaffold(
            padding = padding
        )
        Navigation_Host(navController)
    }
}

@Composable
fun ContentScaffold(padding: PaddingValues) {
}

@Preview
@Composable
fun MainPagePreview() {
    Dashboard_2Theme {
        MainPage()
    }
}