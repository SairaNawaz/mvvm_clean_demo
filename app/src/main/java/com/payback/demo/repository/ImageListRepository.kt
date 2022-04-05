package com.payback.demo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.payback.demo.database.ImagesDatabase
import com.payback.demo.database.asDomainListModel
import com.payback.demo.domain.ImageListItem
import com.payback.demo.network.ImageListService
import com.payback.demo.network.model.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class ImageListRepository @Inject constructor(
    private val imageListService: ImageListService,
    private val database: ImagesDatabase
) {

    fun getImages(search_query: MutableLiveData<String>): LiveData<List<ImageListItem>> {
        println("searchquery: $search_query")
        return Transformations.switchMap(search_query) { address ->
            search_query.value?.let {
                getDbImages(
                    it
                )
            }
        }
    }

    fun getDbImages(search_query: String): LiveData<List<ImageListItem>> {
        return if (!search_query.isEmpty())
            Transformations.map(database.imagesDao.getDatabaseImages(search_query)) {
                it.asDomainListModel()
            }
        else Transformations.map(database.imagesDao.getDatabaseImages()) {
            it.asDomainListModel()
        }
    }

    suspend fun refreshImageList(search_query: String) {
        try {
            val images = imageListService.getImageList(search_query)
            database.imagesDao.insertAll(images.hits.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}