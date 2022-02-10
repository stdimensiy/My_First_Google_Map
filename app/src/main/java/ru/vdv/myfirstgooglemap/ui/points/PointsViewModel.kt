package ru.vdv.myfirstgooglemap.ui.points

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vdv.myfirstgooglemap.domain.CallBack
import ru.vdv.myfirstgooglemap.domain.Point
import ru.vdv.myfirstgooglemap.model.repository.Repository

class PointsViewModel : ViewModel() {
    private val repository = Repository()
    private val _rawPointsList = MutableLiveData<List<Point>>().apply { value = listOf() }
    val preparePointsList: LiveData<List<Point>> = _rawPointsList

    fun savePoint(lat: Double, lon: Double) {
        repository.savePoint(Point(0, lat, lon, "Но точка", "Описание точки", 0))
    }

    fun getAllPoints() {
        repository.getPoints(object : CallBack<List<Point>> {
            override fun onResult(value: List<Point>) {
                _rawPointsList.postValue(value)
            }
        })
    }
}