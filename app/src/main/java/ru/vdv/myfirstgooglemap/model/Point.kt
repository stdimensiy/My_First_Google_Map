package ru.vdv.myfirstgooglemap.model

import java.util.*

data class Point(
    val latitude: Double,
    val longitude: Double,
    val title: String,
    val description: String,
    val dateTime: Date
)
