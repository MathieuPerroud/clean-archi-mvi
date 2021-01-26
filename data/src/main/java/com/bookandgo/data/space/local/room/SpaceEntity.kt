package com.bookandgo.data.space.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Slots")
data class SpaceEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var description: String,
    var picture: String?,
    var type: String,
    var capacity: Int,
    var createdAt: String,
    var createdBy: String?
)