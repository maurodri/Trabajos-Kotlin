package com.example.dashboard_2.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dashboard_2.R
import com.example.dashboard_2.components.DrawableStringQuintuple
import com.example.dashboard_2.components.Filas
import com.example.dashboard_2.components.Quintuple

@Composable
fun Page_Ver_Mas() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = Lacteos)
    }
}

private val Lacteos = listOf(
    Quintuple(
        R.drawable.lt_lacteo_1,
        R.string.yougurt,
    ),
    Quintuple(
        R.drawable.lt_lacteo_2,
        R.string.Avena,
    ),
    Quintuple(

        R.drawable.ic_verdura_2,
        R.string.textoPrueba
    ),
    Quintuple(

        R.drawable.ic_verduras_3,
        R.string.textoPrueba
    ),

    Quintuple(
        R.drawable.ic_frutas_2,
        R.string.textoPrueba
    ),
    Quintuple(
        R.drawable.ic_frutas_3,
        R.string.textoPrueba
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody) }

