package com.example.z4project.model.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity


@Dao
interface ILuDao {
    //ALL
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIlustrations(ilustrationList: List<Ilustration>)

    @Query("SELECT * FROM ilustrater_box_alpha ORDER BY id ASC")
    fun getIlustrationsDDBB(): LiveData<MutableList<Ilustration>>

    @Query("SELECT * FROM ilustrater_box_alpha WHERE id=:url")
    fun getAuthSelectedDDBB(url:String):LiveData<Ilustration>

    //FAV
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSelectioned(insertFav:IlustrationFavEntity)

    @Query("SELECT * FROM ilustrater_fav_box ORDER BY autor ASC")
    fun getFavIlustrations():LiveData<List<IlustrationFavEntity>>
}