package com.example.z4project.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ilustrater_fav_box")
class IlustrationFavEntity(
    @SerializedName("id")val id: String,
    @SerializedName("autor")val autor: String?,
    @SerializedName("url")@PrimaryKey val url:String,
    @SerializedName("fechapub")val fechapub:String,
    @SerializedName("caption")val caption:String?) {
}
