package com.example.dashboard_2.components

import com.example.dashboard_2.R

sealed class items_bar(
    val icon: Int,
    val title: String,
    val ruta: String
) {
    object Boton1: items_bar(R.drawable.ic_bike_24, "Inicio", "boton1")
    object Boton2: items_bar(R.drawable.ic_moto_24, "Contenidos", "boton2")
    object Boton3: items_bar(R.drawable.ic_recycling_24, "Informacion", "boton3")
}