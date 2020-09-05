package com.example.z4project.db

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "ilustrater_box")
class IlustrationEntity(
//    @PrimaryKey val id: String,
    val autor: String?,
    val url:String,
    val fechapub:String,
    val caption:String?) {
}