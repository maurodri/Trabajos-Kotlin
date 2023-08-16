package com.example.dashboard_v2.components

import androidx.compose.ui.graphics.Color
import com.example.dashboard_v2.ui.theme.ColorBlue

data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
    val backgroundColor:Color,
    val mainColor:Color = ColorBlue
)