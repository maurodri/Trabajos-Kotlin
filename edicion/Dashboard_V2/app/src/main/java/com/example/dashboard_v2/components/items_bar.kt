package com.example.dashboard_v2.components

import com.example.dashboard_v2.R

sealed class items_bar(
    val icon: Int,
    val title: String,
    val ruta: String
) {
    object Boton1: items_bar(R.drawable.home_24, "Inicio", "boton1")
    object Boton2: items_bar(R.drawable.contenido_24, "Contenidos", "boton2")
    object Boton3: items_bar(R.drawable.info_24, "Productos", "boton3")
}
