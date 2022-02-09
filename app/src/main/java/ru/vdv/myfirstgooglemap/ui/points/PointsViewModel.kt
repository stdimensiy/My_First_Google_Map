package ru.vdv.myfirstgooglemap.ui.points

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vdv.myfirstgooglemap.model.Point
import java.text.SimpleDateFormat
import java.util.*

class PointsViewModel : ViewModel() {
    val pointsPlug: List<Point> = listOf(

        Point(
            30.15,
            50.25,
            "Первая точка",
            "Описание первой точки",
            Date(convertDateToLong("2021.12.04 17:25"))
        ),
        Point(
            30.15,
            50.25,
            "Вторая точка",
            "Описание второй точки",
            Date(convertDateToLong("2021.12.04 17:25"))
        ),
        Point(
            30.15,
            50.25,
            "Третья точка",
            "Описание третьей точки",
            Date(convertDateToLong("2021.12.04 17:25"))
        ),
        Point(
            30.15,
            50.25,
            "Четвертая точка",
            "Описание четвертой точки",
            Date(convertDateToLong("2021.12.04 17:25"))
        ),
    )

    private val _rawPointsList = MutableLiveData<List<Point>>().apply { value = pointsPlug }
    val preparePointsList: LiveData<List<Point>> = _rawPointsList

    //временно пока во VM живет заглушка
    private fun convertDateToLong(date: String): Long {
        val df = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return df.parse(date).time
    }
}