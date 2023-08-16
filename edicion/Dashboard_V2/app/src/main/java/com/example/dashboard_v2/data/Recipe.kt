package com.example.dashboard_v2.data
import androidx.annotation.DrawableRes
import com.example.dashboard_v2.R


// I have prepared the following data structures and resources to skip the boring part

data class Recipe(
    val title: String,
    val category: String,
    val cookingTime: String,
    val energy: String,
    val rating: String,
    val description: String,
    val reviews: String,
    val ingredients: List<Ingredient>
)

data class Ingredient(@DrawableRes val image: Int, val title: String, val subtitle: String)

val strawberryCake = Recipe(
    title = "Tienda Sena",
    category = "CBA Mosquera",
    cookingTime = "50 min",
    energy = "620 likes",
    rating = "4,9",
    description = "La app Tiendas SENA es una plataforma digital que te permite comprar y vender productos elaborados por aprendices, instructores y egresados del SENA. Puedes encontrar una gran variedad de artículos de diferentes categorías, como artesanías, alimentos, tecnología y más. Además, puedes apoyar el emprendimiento y la innovación de la comunidad SENA, y contribuir al desarrollo social y económico del país. Si quieres conocer más sobre esta app, puedes visitar su página web o descargarla desde Google Play o App Store. ¡Anímate a explorar la app Tiendas SENA y descubre todo lo que tiene para ofrecerte!",
    reviews = "35 Productos     430 Comentarios",
    ingredients = listOf(
        Ingredient(R.drawable.hv_huevo_aa, "Huevo AA 30ud", "$20000"),
        Ingredient(R.drawable.eggs, "Huevo fino 30ud", "$30000"),
        Ingredient(R.drawable.hv_huevo_aa, "Huevo B 30ud", "$34000"),
        Ingredient(R.drawable.strawberry, "Fresa 30ud", "$7000"),
        Ingredient(R.drawable.ic_granos, "Grano 1ud", "$3500"),
        Ingredient(R.drawable.mind, "Menta 20g", "$3000"),
        Ingredient(R.drawable.vanilla, "Vanilla", "$2000"),
    )
)