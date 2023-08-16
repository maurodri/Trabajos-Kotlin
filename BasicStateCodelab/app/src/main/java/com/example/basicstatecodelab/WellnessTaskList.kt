package com.example.basicstatecodelab
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



@Composable
fun WellnessTaskList(
    list: List<WellnessTask>, // parámetro de tipo List<WellnessTask> que representa la lista de tareas
    modifier: Modifier = Modifier, // parámetro opcional de tipo Modifier con un valor predeterminado de Modifier
    onCheckedTask: (WellnessTask, Boolean) -> Unit, // parámetro de tipo lambda que se llama cuando cambia el estado de marcado de una tarea
    onCloseTask: (WellnessTask) -> Unit, // parámetro de tipo lambda que se llama cuando se cierra una tarea
) {
    LazyColumn(modifier = modifier){ // crea un LazyColumn con el modificador dado
        items(
            items = list, // establece el parámetro items en la lista de tareas dada
            key = { task -> task.id} // establece el parámetro key en una función lambda que toma una tarea y devuelve su identificador
        ){ task -> // para cada tarea en la lista
            WellnessTaskItem( // agrega un WellnessTaskItem al LazyColumn
                taskName = task.label, // establece el parámetro taskName en la etiqueta de la tarea
                checked = task.checked, // establece el parámetro checked en el estado marcado de la tarea
                onCheckedChange = {checked -> onCheckedTask(task, checked)}, // establece el parámetro onCheckedChange en una función lambda que toma un booleano y llama a la función lambda onCheckedTask con la tarea y el booleano dados como parámetros
                onClose = { onCloseTask(task)}) // establece el parámetro onClose en una función lambda que llama a la función lambda onCloseTask con la tarea dada como parámetro
        }
    }
}

