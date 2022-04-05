package com.payback.demo.network.model


import com.payback.demo.database.DatabaseImageListItem
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkImageListItem(
    var id: Int,
    var type: String,
    var pageURL: String,
    var tags: String,
    var previewURL: String,
    var previewWidth: Int,
    var previewHeight: Int,
    var webformatURL: String,
    var webformatWidth: Int,
    var webformatHeight: Int,
    var largeImageURL: String,
    var imageWidth: Int,
    var imageHeight: Int,
    var imageSize: Int,
    var views: Int,
    var downloads: Int,
    var collections: Int,
    var likes: Int,
    var comments: Int,
    var user_id: Int,
    var user: String,
    var userImageURL: String

)

fun List<NetworkImageListItem>.asDatabaseModel(): List<DatabaseImageListItem> {
    return map {
        DatabaseImageListItem(
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
            userId = it.user_id,
            user = it.user,
            userImageURL = it.userImageURL
        )
    }
}