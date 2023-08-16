package com.example.dashboard_v2.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dashboard_v2.R
import com.example.dashboard_v2.components.DrawableStringQuintuple
import com.example.dashboard_v2.components.Filas
import com.example.dashboard_v2.components.Quintuple

@Composable
fun Page_Huevos() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = Huevos)
    }
}

private val Huevos = listOf(
    Quintuple(
        R.drawable.hv_huevob,
        R.string.huevob,
        R.string.huevob_detalles
    ),
    Quintuple(
        R.drawable.hv_huevo_aa,
        R.string.huevoaa,
        R.string.huevoaa_detalles

    ),
    Quintuple(

        R.drawable.hv_huevos_aaa,
        R.string.huevoaaa,
        R.string.huevoaaa_detalles

    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody, it.detallebody) }
