package com.example.basicstatecodelab
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable
fun StatelessCounter(
    count: Int, // parámetro de tipo Int que representa el conteo actual
    onIncrement: ()-> Unit, // parámetro de tipo lambda que se llama cuando se incrementa el conteo
    modifier: Modifier = Modifier // parámetro opcional de tipo Modifier con un valor predeterminado de Modifier
){
    Column(modifier = Modifier.padding(16.dp)) { // crea una Columna con un modificador que agrega un relleno de 16.dp
        Button(
            onClick = onIncrement, // establece el parámetro onClick en la función lambda onIncrement
            Modifier.padding(top = 8.dp), // agrega un modificador que agrega un relleno superior de 8.dp
            enabled = count < 10 // establece el parámetro enabled en verdadero si el conteo es menor a 10
        ) {
            Text("Add one") // agrega un Texto con el texto "Add one" al Botón
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){ // función Composable que toma un parámetro opcional de tipo Modifier con un valor predeterminado de Modifier
    var count by rememberSaveable { // declara una variable mutable count y la inicializa con el valor guardado por rememberSaveable o 0 si no hay valor guardado
        mutableStateOf(0) // inicializa el estado mutable con 0
    }
    StatelessCounter(count, { count ++ }, modifier) // llama a la función StatelessCounter con los parámetros count, una función lambda que incrementa count y el modificador dado
}

/*
@Composable
fun WaterCounter(modifier : Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        // Changes to count are now tracked by Compose
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0){
           /*var showTask by remember { mutableStateOf(true) }
            if (showTask){
                WellnessTaskItem(
                    onClose = { showTask = false},
                    taskName = "Have you taken your 15 minute walk today?")
            }*/
        Text(
            text = "You' ve had $count glasses.",
           )
        }
        //Row(Modifier.padding(top = 8.dp)){
        Button(onClick ={ count++ },  modifier = modifier.padding(top= 8.dp), enabled = count < 10
        ) {
            Text("Add one")
        }
          /*  Button(onClick = { count = 0}, Modifier.padding(start = 8.dp)) {
                Text("Clear water count")
            }*/
    }
}*/