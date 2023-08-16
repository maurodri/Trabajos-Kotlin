package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen (
    modifier : Modifier = Modifier, // parámetro opcional de tipo Modifier con un valor predeterminado de Modifier
    wellnessViewModel: WellnessViewModel = viewModel() // parámetro opcional de tipo WellnessViewModel con un valor predeterminado de viewModel()
) {
    Column(modifier = modifier) { // crea una Columna con el modificador dado
        StatefulCounter() // agrega un StatefulCounter a la Columna
        WellnessTaskList( // agrega un WellnessTaskList a la Columna
            list = wellnessViewModel.tasks, // establece el parámetro de lista en las tareas del wellnessViewModel
            onCheckedTask = {task, checked -> // establece el parámetro onCheckedTask en una función lambda que toma una tarea y un booleano verificado como parámetros
                wellnessViewModel.changeTaskChecked(task, checked) // llama a la función changeTaskChecked en el wellnessViewModel con los parámetros de tarea y verificado dados
            },
            onCloseTask = { task -> // establece el parámetro onCloseTask en una función lambda que toma una tarea como parámetro
                wellnessViewModel.remove(task) // llama a la función remove en el wellnessViewModel con el parámetro de tarea dado
            } )
    }
}
