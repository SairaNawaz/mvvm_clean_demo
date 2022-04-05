package com.payback.demo.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ImagesDao {
    // Image List
    @Query("select * from DatabaseImageListItem WHERE tags LIKE '%' || :search_query || '%' order by id asc")
    fun getDatabaseImages(search_query:String): LiveData<List<DatabaseImageListItem>>

    @Query("select * from DatabaseImageListItem order by id asc")
    fun getDatabaseImages(): LiveData<List<DatabaseImageListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(images: List<DatabaseImageListItem>)

    // single Image
    @Query("select * from DatabaseImageListItem WHERE id = :id")
    fun getImageDetails(id: Int): LiveData<DatabaseImageListItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImageDetails(databaseImageDetails: DatabaseImageListItem)
}

@Database(entities = [DatabaseImageListItem::class], version = 1)
abstract class ImagesDatabase : RoomDatabase() {
    abstract val imagesDao: ImagesDao
}