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
fun Page_Frutas_Verduras() {
    Column(modifier = Modifier.padding(bottom = 70.dp)) {
        Filas(collection = DatosFloresAndVerduras)
    }
}

private val DatosFloresAndVerduras = listOf(
    Quintuple(
        R.drawable.ic_frutas_2,
        R.string.Kiwi,
        R.string.Kiwi_detalles
    ),
    Quintuple(
        R.drawable.ic_frutas_3,
        R.string.Manzana_fresa,
        R.string.Manzana_fresa_detalle
    ),
    Quintuple(

        R.drawable.ic_verdura_2,
        R.string.Verduras,
        R.string.Verdura_detalle
    ),
    Quintuple(

        R.drawable.ic_verduras_3,
        R.string.Zanahoria,
        R.string.Zanahoria_detalle
    ),

    ).map { DrawableStringQuintuple(it.imgbody, it.textbody, it.detallebody) }


@Preview(showBackground = true)
@Composable
fun Page_Frutas_VerdurasPreview() {
    Page_Frutas_Verduras()
}