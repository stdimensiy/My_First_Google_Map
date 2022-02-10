package ru.vdv.myfirstgooglemap

import android.app.Application
import androidx.room.Room
import ru.vdv.myfirstgooglemap.model.room.PointsDB

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Instance = this
    }

    companion object {
        private var Instance: App? = null
        private var db: PointsDB? = null
        private const val DB_NAME = "Points.db"

        fun getDb(): PointsDB {
            if (db == null) {
                db = Room.databaseBuilder(
                    Instance!!.applicationContext, PointsDB::class.java, DB_NAME
                ).build()
            }
            return db as PointsDB
        }
    }
}