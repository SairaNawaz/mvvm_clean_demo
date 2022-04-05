package com.payback.demo.di

import android.content.Context
import androidx.room.Room
import com.payback.demo.database.ImagesDao
import com.payback.demo.database.ImagesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ImagesDatabase {
        return Room.databaseBuilder(
            appContext,
            ImagesDatabase::class.java,
            "Images"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideChannelDao(imagesDatabase: ImagesDatabase): ImagesDao {
        return imagesDatabase.imagesDao
    }

}