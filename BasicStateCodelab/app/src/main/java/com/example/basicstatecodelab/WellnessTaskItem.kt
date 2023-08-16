package com.example.basicstatecodelab
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WellnessTaskItem (
    taskName: String, // parámetro de tipo String que representa el nombre de la tarea
    checked: Boolean, // parámetro de tipo Boolean que representa si la tarea está marcada
    onCheckedChange: (Boolean)-> Unit, // parámetro de tipo lambda que se llama cuando cambia el estado de marcado de la tarea
    onClose: () -> Unit, // parámetro de tipo lambda que se llama cuando se cierra la tarea
    modifier: Modifier = Modifier // parámetro opcional de tipo Modifier con un valor predeterminado de Modifier
){
    Row(
        modifier = modifier, // establece el modificador del Row en el modificador dado
        verticalAlignment = Alignment.CenterVertically // establece la alineación vertical del Row en el centro verticalmente
    ) {
        Text(
            modifier = Modifier // agrega un modificador al Texto
                .weight(1f) // establece el peso del Texto en 1f
                .padding(start = 16.dp), // agrega un relleno al inicio del Texto de 16.dp
            text = taskName) // establece el texto del Texto en el nombre de la tarea dado
        Checkbox(checked = checked, onCheckedChange = onCheckedChange) // agrega un Checkbox con el estado marcado dado y la función lambda onCheckedChange como parámetro onCheckedChange
        IconButton(onClick = onClose) { // agrega un IconButton con la función lambda onClose como parámetro onClick
            Icon(Icons.Filled.Close, contentDescription = "Close") // agrega un Icono con el icono Icons.Filled.Close y una descripción de contenido de "Close" al IconButton
        }
    }
}
