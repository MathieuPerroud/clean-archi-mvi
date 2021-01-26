package com.bookandgo.data.sources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bookandgo.data.space.local.room.SpaceDao
import com.bookandgo.data.space.local.room.SpaceEntity

@Database(entities = [
    SpaceEntity::class
], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun slotDao(): SpaceDao

}
