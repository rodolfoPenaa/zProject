package com.example.z4project.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ilustrater_box_alpha")
data class Ilustration (
    @SerializedName("id")val id:String,
    @SerializedName("autor")val autor:String?,
//    val publicadopor:String?,
    @SerializedName("url")@PrimaryKey val url:String,
    val fechapub:String,
//    val tipo:String,
//    val formato:String,
//    val color:Boolean,
//    val original:String,
//    val afectos:String?,
//    val tags:String,
    @SerializedName("caption")val caption:String?,
//    val descripcionimagen:String,
//    val textoimagen:String
    @SerializedName("inFav")var inFav:Boolean=false
) {
}