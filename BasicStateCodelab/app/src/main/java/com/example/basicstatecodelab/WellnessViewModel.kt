package com.example.basicstatecodelab
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class WellnessViewModel : ViewModel(){ // clase WellnessViewModel que hereda de ViewModel
    private val _task = getWellnessTasks().toMutableStateList() // declara una variable privada _task y la inicializa con el resultado de llamar a la función getWellnessTasks y convertirlo en una lista de estado mutable
    val tasks: List<WellnessTask> // declara una propiedad pública tasks de tipo List<WellnessTask>
        get() = _task // establece el getter de la propiedad tasks en una función que devuelve el valor de _task
    fun remove(item: WellnessTask) { // función pública remove que toma un parámetro de tipo WellnessTask
        _task.remove(item) // llama a la función remove en _task con el parámetro item dado
    }
    fun changeTaskChecked(item: WellnessTask, checked: Boolean) = // función pública changeTaskChecked que toma un parámetro de tipo WellnessTask y un parámetro de tipo Boolean
        tasks.find { it.id == item.id }?.let {task -> // busca una tarea en la lista tasks cuyo identificador sea igual al identificador del parámetro item y, si se encuentra, llama a la función let con la tarea encontrada como parámetro
            task.checked = checked // establece el estado marcado de la tarea encontrada en el valor del parámetro checked dado
        }
}

private fun getWellnessTasks() = List(30) {i ->WellnessTask(i, "Task # $i")} // función privada getWellnessTasks que devuelve una lista de 30 tareas con identificadores del 0 al 29 y etiquetas "Task # 0" a "Task # 29"
