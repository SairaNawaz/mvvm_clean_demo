package com.payback.demo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.payback.demo.database.ImagesDatabase
import com.payback.demo.database.asDomainModel
import com.payback.demo.domain.ImageListItem
import javax.inject.Inject

class ImageDetailsRepository @Inject constructor(private val database: ImagesDatabase) {

    fun getImageDetails(id: Int): LiveData<ImageListItem> {
        return Transformations.map(database.imagesDao.getImageDetails(id)) {
            it.asDomainModel()
        }
    }
}