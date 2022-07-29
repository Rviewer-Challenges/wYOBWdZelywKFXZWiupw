package com.chrismagaa.simple_lector_rss.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chrismagaa.simple_lector_rss.data.persistence.dao.PostDao
import com.chrismagaa.simple_lector_rss.data.persistence.entities.PostEntity
import com.chrismagaa.simple_lector_rss.utils.RoomDateConverter

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
@TypeConverters(RoomDateConverter::class)
abstract class FeedDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
}