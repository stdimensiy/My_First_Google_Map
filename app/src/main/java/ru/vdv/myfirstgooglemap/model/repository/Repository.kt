package ru.vdv.myfirstgooglemap.model.repository

import ru.vdv.myfirstgooglemap.App
import ru.vdv.myfirstgooglemap.domain.CallBack
import ru.vdv.myfirstgooglemap.domain.Point
import ru.vdv.myfirstgooglemap.model.room.MyPointsDao

class Repository : ILocalRepo {
    private val myPointsDao: MyPointsDao = App.getDb().myPointsDao()

    override fun savePoint(point: Point) {
        val thread = object : Thread() {
            override fun run() {
                super.run()
                myPointsDao.setPoint(point)
            }
        }
        thread.start()
    }

    override fun getPoints(callBack: CallBack<List<Point>>) {
        val thread = object : Thread() {
            override fun run() {
                super.run()
                callBack.onResult(myPointsDao.getPoints())
            }
        }
        thread.start()
    }
}