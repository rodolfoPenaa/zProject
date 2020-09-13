package com.example.z4project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ilustrater_fav_box")
class IlustrationFavEntity(
    @PrimaryKey val id: String,
    val autor: String?,
    val url:String,
    val fechapub:String,
    val caption:String?) {
}