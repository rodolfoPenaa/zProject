package com.example.z4project.model.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import javax.net.ssl.HttpsURLConnection


@Dao
interface ILuDao {
    //ALL
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIlustrations(ilustrationList: List<Ilustration>)

    @Update
    suspend fun insertAilustration(ilustration: Ilustration)

    @Delete
    fun deleteFromall(changeToFav0: Ilustration)

    @Update
    fun updateAllDDBB(changeToFav: Ilustration)

    /*@Query("SELECT * FROM ilustrater_box_alpha ORDER BY id ASC")
    fun getIlustrationsDDBB(): LiveData<MutableList<Ilustration>>*/

    @Query("SELECT * FROM ilustrater_box_alpha WHERE inFav=0") // [0= false - 1= true]
    fun getIlustrationsDDBB():LiveData<MutableList<Ilustration>>

    @Query("SELECT * FROM ilustrater_box_alpha WHERE id=:url")
    fun getAuthSelectedDDBB(url:String):LiveData<Ilustration>

    //FAV
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSelectioned(insertFav:IlustrationFavEntity)

    @Delete()
    fun deleteFromFav(changeToAll: IlustrationFavEntity)

    @Query("SELECT * FROM ilustrater_fav_box ORDER BY autor ASC")
    fun getFavIlustrations():LiveData<List<IlustrationFavEntity>>

}