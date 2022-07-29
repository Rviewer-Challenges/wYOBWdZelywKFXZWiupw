package com.chrismagaa.simple_lector_rss.di

import android.content.Context
import androidx.room.Room
import com.chrismagaa.simple_lector_rss.data.persistence.FeedDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val FEED_DATABASE_NAME = "feed_database"

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            FeedDatabase::class.java,
            FEED_DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun providePostDao(db: FeedDatabase) = db.postDao()


}