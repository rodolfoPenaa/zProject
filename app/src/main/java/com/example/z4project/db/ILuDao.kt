package com.example.z4project.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.z4project.model.Ilustration


@Dao
interface ILuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIlustrations(ilustrationList: List<Ilustration>)

    @Query("SELECT * FROM ilustrater_box_alpha ORDER BY id ASC")
    fun getIlustrationsDDBB(): LiveData<List<Ilustration>>

}