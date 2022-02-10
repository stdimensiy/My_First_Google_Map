package ru.vdv.myfirstgooglemap.model.room

import androidx.room.*
import ru.vdv.myfirstgooglemap.domain.Point

@Dao
interface MyPointsDao {
    @Query("SELECT * from Point")
    fun getPoints(): List<Point>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setPoint(point: Point)

    @Update
    fun updatePoint(point: Point)

    @Delete
    fun deletePoint(point: Point)
}