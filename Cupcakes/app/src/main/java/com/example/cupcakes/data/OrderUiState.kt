package com.example.cupcakes.data

/**
 * Data class that represents the current UI state in term of [quantity], [flavor],
 * [dataOptions], selected pickup [date] and [price]

 * Clase de datos que representa el estado actual de la interfaz de usuario en términos de [cantidad], [sabor],
 * [opciones_de_datos], seleccion de recogida [fecha] y [precio]
 */

data class OrderUiState(
    /** Selected cupcake quantity (1, 6, 12)
     * Cantidad de cupcakes seleccionados (1, 6, 12)*/
    val quantity: Int = 0,
    /**
     * Flavor of the cupcakes in the order (such as "Chocolate", "Vainilla", etc...)
     * Sabor de los cupcakes en el pedido (como "Chocolate", "Vainilla", etc...)
     */
    val flavor: String = "",
    /**
     * Selected date for pickup (such as "Jan 1")
     * Fecha seleccionada para la recogida (como "Ene 1")
     */
    val date: String = "",
    /**
     * Total price for the order
     * Precio total del pedido
     */
    val price: String = "",
    /**
     * Available pickup dates for the order
     * Fechas de recogida disponibles para el pedido
     */
    val pickupOptions: List<String> = listOf()
)