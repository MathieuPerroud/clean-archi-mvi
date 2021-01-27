package com.bookandgo.data.space.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Slots")
data class SpaceEntity(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("IdSpace")
    var id: Long = 0,
    @SerializedName("Name")
    var name: String,
    @SerializedName("Description")
    var description: String,
    @SerializedName("Picture")
    var picture: String?,
    @SerializedName("Type")
    var type: String,
    @SerializedName("Capacity")
    var capacity: Int,
    @SerializedName("CreatedAt")
    var createdAt: String,
    @SerializedName("CreatedBy")
    var createdBy: String?
)