package com.example.dashboard_v2.components

import com.example.dashboard_v2.R

sealed class MenuItem(
    val icon: Int,
    val title: String,
    val ruta: String
) {
    object  Page1: MenuItem(R.drawable.ic_principal, "Principal", "page1" )
    object  Page2: MenuItem(R.drawable.ic_flores, "Flores", "page2" )
    object  Page3: MenuItem(R.drawable.ic_frutas, "Frutas y Verduras", "page3" )
    object  Page4: MenuItem(R.drawable.ic_lacteos, "Huevos", "page4" )
    object  Page5: MenuItem(R.drawable.ic_lacteos, "lacteos", "page5" )
    object  Page6: MenuItem(R.drawable.ic_vermas, "Ver mas", "page6" )
    object  Page7: MenuItem(R.drawable.ic_location_24, "Ubicacion", "page7" )
}