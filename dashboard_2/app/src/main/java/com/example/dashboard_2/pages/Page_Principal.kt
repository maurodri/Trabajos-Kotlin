package com.example.dashboard_2.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboard_2.R
import com.example.dashboard_2.ui.theme.Dashboard_2Theme

@Composable
fun Page_Principal() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    if (showDialog) {
        AlertDialog(onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { }) {
                    Text(text = "Login")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = "Confirmar") },
            text = { Text(text = "Esto es un texto de prueba para el cuadro de dialogo xd") }
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.sena),
            contentDescription = "Simbolo sena",
            modifier = Modifier.size(230.dp),
            alignment = Alignment.TopStart
        )
        Text(
            text = "Bienvenidos a,", color = Color.Green, fontSize = 40.sp
        )
        Text(
            text = "Tienda CBA SENA", fontSize = 20.sp
        )

        Row(modifier = Modifier.padding(all = 10.dp)) {
            OutlinedButton(onClick = { showDialog = true }) {
                Text(text = "Inicio", fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Page_PrincipalPreview() {
    Dashboard_2Theme() {
        Page_Principal()
    }
}