package ru.vdv.myfirstgooglemap.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Point(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val title: String,
    val description: String,
    val dateTime: Long
)
