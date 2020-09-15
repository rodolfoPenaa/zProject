package com.example.z4project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ilustrater_box_alpha")
class Ilustration (
    val id:String,
    val autor:String?,
//    val publicadopor:String?,
    @PrimaryKey val url:String,
    val fechapub:String,
//    val tipo:String,
//    val formato:String,
//    val color:Boolean,
//    val original:String,
//    val afectos:String?,
//    val tags:String,
    val caption:String?,
//    val descripcionimagen:String,
//    val textoimagen:String
) {
}