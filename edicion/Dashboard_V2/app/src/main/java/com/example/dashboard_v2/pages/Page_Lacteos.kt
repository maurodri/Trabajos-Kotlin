package com.example.dashboard_v2.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dashboard_v2.R
import com.example.dashboard_v2.components.DrawableStringQuintuple
import com.example.dashboard_v2.components.Filas
import com.example.dashboard_v2.components.Quintuple

@Composable
fun Page_Lacteos() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = Lacteos)
    }
}

private val Lacteos = listOf(
    Quintuple(
        R.drawable.lt_lacteo_1,
        R.string.yougurt,
        R.string.yougurt_detalle
    ),
    Quintuple(
        R.drawable.lt_lacteo_2,
        R.string.Avena,
        R.string.Avena_detalle
    ),
    Quintuple(

        R.drawable.lt_lacteo_3,
        R.string.batido,
        R.string.batido_detalle
    ),
    Quintuple(

        R.drawable.lt_lacteo_4,
        R.string.leche,
        R.string.Leche_detalle
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody, it.detallebody) }

@Preview(showBackground = true)
@Composable
fun Page_LacteosPreview() {
    Page_Lacteos()
}