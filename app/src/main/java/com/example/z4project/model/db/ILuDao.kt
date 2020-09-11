package com.example.z4project.model.db

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
    fun getIlustrationsDDBB(): LiveData<MutableList<Ilustration>>

    @Query("SELECT * FROM ilustrater_box_alpha WHERE id=:id")
    fun getSelected(id:String):LiveData<Ilustration>

}