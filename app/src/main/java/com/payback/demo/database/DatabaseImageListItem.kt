package com.payback.demo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.payback.demo.domain.ImageListItem

@Entity
data class DatabaseImageListItem constructor(
    @PrimaryKey
    val id: Int,
    val type: String,
    val pageURL: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageURL: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val collections: Int,
    val likes: Int,
    val comments: Int,
    val userId: Int,
    val user: String,
    val userImageURL: String
)

fun DatabaseImageListItem.asDomainModel(): ImageListItem {
    this.apply {
        return ImageListItem(
            id, type, pageURL, tags, previewURL, previewWidth, previewHeight,
            webformatURL, webformatWidth, webformatHeight, largeImageURL, imageWidth, imageHeight,
            imageSize, views, downloads, collections, likes, comments, userId, user, userImageURL
        )
    }
}

fun List<DatabaseImageListItem>.asDomainListModel(): List<ImageListItem> {
    return map {
        ImageListItem(
            id = it.id,
            type = it.type,
            pageURL = it.pageURL,
            tags = it.tags,
            previewURL = it.previewURL,
            previewWidth = it.previewWidth,
            previewHeight = it.previewHeight,
            webformatURL = it.webformatURL,
            webformatWidth = it.webformatWidth,
            webformatHeight = it.webformatHeight,
            largeImageURL = it.largeImageURL,
            imageWidth = it.imageWidth,
            imageHeight = it.imageHeight,
            imageSize = it.imageSize,
            views = it.views,
            downloads = it.downloads,
            collections = it.collections,
            likes = it.likes,
            comments = it.comments,
            userId = it.userId,
            user = it.user,
            userImageURL = it.userImageURL
        )
    }
}