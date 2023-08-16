package com.example.basicstatecodelab
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class WellnessTask(
    val id: Int, // parámetro de tipo Int que representa el identificador de la tarea
    val label: String, // parámetro de tipo String que representa la etiqueta de la tarea
    val initialChecked: Boolean = false // parámetro opcional de tipo Boolean que representa si la tarea está marcada inicialmente, con un valor predeterminado de falso
){
    var checked by mutableStateOf(initialChecked) // declara una variable mutable checked y la inicializa con el valor de initialChecked utilizando mutableStateOf
}
