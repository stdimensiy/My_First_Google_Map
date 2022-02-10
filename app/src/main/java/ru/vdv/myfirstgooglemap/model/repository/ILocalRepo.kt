package ru.vdv.myfirstgooglemap.model.repository

import ru.vdv.myfirstgooglemap.domain.CallBack
import ru.vdv.myfirstgooglemap.domain.Point

interface ILocalRepo {
    fun savePoint(point: Point)
    fun getPoints(callBack: CallBack<List<Point>>)
}