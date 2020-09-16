package com.example.z4project.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity

@Database(entities = [Ilustration::class, IlustrationFavEntity::class],version = 5113, exportSchema = false)
abstract class R00mDataBase:RoomDatabase() {
    abstract fun dataBASE(): ILuDao
    companion object{
        @Volatile
        private var ddbb: R00mDataBase? = null
        fun getDDBB(context: Context): R00mDataBase{
            if (ddbb==null) synchronized(this){
                ddbb=Room.databaseBuilder(context.applicationContext,
                    R00mDataBase::class.java,
                    "ilustrater_box").build()
            }
            return ddbb!!
        }
       /* private var favDDBB:R00mDataBase? = null
        fun getFavDDBB(context: Context): R00mDataBase{
            if (favDDBB==null) synchronized(this){
                favDDBB=Room.databaseBuilder(context.applicationContext,
                    R00mDataBase::class.java,
                    "ilustrater_fav_box").build()
            }
            return favDDBB!!
        }*/
    }
}