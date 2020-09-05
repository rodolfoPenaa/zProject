package com.example.z4project.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.z4project.model.Ilustration

@Database(entities = [Ilustration::class],version = 1013, exportSchema = false)
abstract class R00mDataBase:RoomDatabase() {
    abstract fun dataBASE(): ILuDao
    companion object{
        @Volatile
        private var ddbb: R00mDataBase? = null

        fun getDDBB(context: Context): R00mDataBase{
            if (ddbb==null) synchronized(this){
                ddbb=Room.databaseBuilder(context.applicationContext,
                    R00mDataBase::class.java,
                    "ilustrater_box_alpha").build()
            }
            return ddbb!!
        }
    }
}