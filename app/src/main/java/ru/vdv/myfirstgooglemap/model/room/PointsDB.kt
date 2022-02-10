package ru.vdv.myfirstgooglemap.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.vdv.myfirstgooglemap.domain.Point

@Database(entities = [Point::class], version = 1, exportSchema = false)
abstract class PointsDB : RoomDatabase() {
    abstract fun myPointsDao(): MyPointsDao
}