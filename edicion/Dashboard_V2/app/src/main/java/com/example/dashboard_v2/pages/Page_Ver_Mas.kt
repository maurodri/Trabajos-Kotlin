
package com.example.dashboard_v2.pages
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import kotlinx.serialization.json.jsonObject
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.dashboard_v2.R
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.double
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import java.util.Calendar
@Composable
fun getImageResource(humidity: Double, temperature: Double): Int {
    return when {
        humidity > 80 -> R.drawable.ic_rainy
        temperature > 30 -> R.drawable.ic_sunny
        else -> R.drawable.ic_cloudy
    }
}
@Composable
fun WeatherView() {
    val currentWeatherData = remember { mutableStateOf(WeatherData()) }
    val forecastWeatherData = remember { mutableStateOf(listOf<WeatherData>()) }
    val selectedDay = remember { mutableStateOf(-1) }
    val apiKey = "2b2e99d0edf4ab4b3427b12eac9215cb"
    val city = "Mosquera"
    val country = "CO"
    val currentWeatherUrl =
        "https://api.openweathermap.org/data/2.5/weather?q=Mosquera,CO&appid=2b2e99d0edf4ab4b3427b12eac9215cb&units=metric"
    val forecastWeatherUrl =
        "https://api.openweathermap.org/data/2.5/forecast?q=Mosquera,CO&appid=2b2e99d0edf4ab4b3427b12eac9215cb&units=metric"

    LaunchedEffect(key1 = currentWeatherUrl) {
        val response = fetchCurrentWeatherData(currentWeatherUrl)
        currentWeatherData.value = response
    }

    LaunchedEffect(key1 = forecastWeatherUrl) {
        val response = fetchForecastWeatherData(forecastWeatherUrl)
        forecastWeatherData.value = response.chunked(8).map { dayData ->
            WeatherData(
                temperature = dayData.map { it.temperature }.average(),
                feelsLike = dayData.map { it.feelsLike }.average(),
                humidity = dayData.map { it.humidity }.average(),
                windSpeed = dayData.map { it.windSpeed }.average()
            )
        }
    }

    val backgroundColor = when {
        currentWeatherData.value.temperature > 30 -> Brush.linearGradient(
            colors = listOf(Color(0xFFf2994a), Color(0xFFf2c94c)),
            start = Offset(0f, 0f),
            end = Offset(0f, 200f)
        )
        currentWeatherData.value.temperature > 20 -> Brush.linearGradient(
            colors = listOf(Color(0xFF6fcf97), Color(0xFF66DE93)),
            start = Offset(0f, 0f),
            end = Offset(0f, 200f)
        )
        else -> Brush.linearGradient(
            colors = listOf(Color(0xFF56CCF2), Color(0xFF2F80ED)),
            start = Offset(0f, 0f),
            end = Offset(0f, 200f)
        )
    }
    val backgroundColorCard = when {
        currentWeatherData.value.temperature > 30 -> Brush.linearGradient(
            colors = listOf(Color(0xFFF0872A), Color(0xFFEEC137)),
            start = Offset(0f, 0f),
            end = Offset(0f, 200f)
        )
        currentWeatherData.value.temperature > 20 -> Brush.linearGradient(
            colors = listOf(Color(0xFF44C57A), Color(0xFF4ADB80)),
            start = Offset(0f, 0f),
            end = Offset(0f, 200f)
        )
        else -> Brush.linearGradient(
            colors = listOf(Color(0xFF2FC1F0), Color(0xFF1C75EC)),
            start = Offset(0f, 0f),
            end = Offset(0f, 200f)
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$city, $country",
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${currentWeatherData.value.temperature}°C",
                style = MaterialTheme.typography.h2,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Feels like: ${currentWeatherData.value.feelsLike}°C",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Text(
                text = "Humidity: ${currentWeatherData.value.humidity}%",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Text(
                text = "Wind speed: ${currentWeatherData.value.windSpeed} km/h",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Box(modifier = Modifier.height(20.dp))

            val daysOfWeek = listOf("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")
            val currentDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1

            LazyRow {
                items(forecastWeatherData.value.size) { index ->
                    val data = forecastWeatherData.value[index]
                    val dayOfWeek = daysOfWeek[(currentDayOfWeek + index + 1) % 7]
                    Card(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(width = 1.dp, color = Color.Gray),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Column() {
                            //Cuerpo
                            Image(
                                painter = painterResource(getImageResource(data.humidity, data.temperature)),
                                contentDescription = "Imagenes",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .background(backgroundColorCard)
                                    .fillMaxWidth()
                                    .height(194.dp)
                                    .clip(RectangleShape)
                            )
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(start = 16.dp, end = 20.dp, top = 16.dp).fillMaxWidth()
                            ) {
                                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                    Text(
                                        text = dayOfWeek,
                                        textAlign = TextAlign.Center,
                                        maxLines = 4,
                                        overflow = TextOverflow.Ellipsis,
                                        style = MaterialTheme.typography.h6
                                    )
                                }
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.padding(start = 16.dp, end = 20.dp, top = 16.dp).fillMaxWidth()
                            ) {
                                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                                    Text(
                                        text = " %.1f°C".format(data.temperature),
                                        maxLines = 4,
                                        overflow = TextOverflow.Ellipsis,
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                            }

                        }


                    }
                }
            }


        }
    }




}


data class WeatherData(
    val temperature: Double =
        0.0,
    val feelsLike:
    Double =
        0.0,
    val humidity:
    Double =
        0.0,
    val windSpeed:
    Double =
        0.0
)

val client = HttpClient()

suspend fun fetchCurrentWeatherData(url: String): WeatherData {
    val response = client.get<String>(url)
    val json = Json.decodeFromString<JsonObject>(response)
    val main = json["main"]?.jsonObject
    return WeatherData(
        temperature = main?.get("temp")?.jsonPrimitive?.double ?: 0.0,
        feelsLike = main?.get("feels_like")?.jsonPrimitive?.double ?: 0.0,
        humidity = main?.get("humidity")?.jsonPrimitive?.double ?: 0.0,
        windSpeed = json["wind"]?.jsonObject?.get("speed")?.jsonPrimitive?.double ?: 0.0
    )
}

suspend fun fetchForecastWeatherData(url: String): List<WeatherData> {
    val response = client.get<String>(url)
    val json = Json.decodeFromString<JsonObject>(response)
    val list = json["list"]?.jsonArray
    return list?.mapNotNull { item ->
        val main = item.jsonObject["main"]?.jsonObject
        val weatherData = WeatherData(
            temperature = main?.get("temp")?.jsonPrimitive?.double ?: 0.0,
            feelsLike = main?.get("feels_like")?.jsonPrimitive?.double ?: 0.0,
            humidity = main?.get("humidity")?.jsonPrimitive?.double ?: 0.0,
            windSpeed =
            item.jsonObject["wind"]?.jsonObject?.get("speed")?.jsonPrimitive?.double ?: 0.0
        )
        weatherData
    } ?: emptyList()
}



