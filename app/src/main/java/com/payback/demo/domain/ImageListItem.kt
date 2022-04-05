package com.payback.demo.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageListItem(
    val id: Int? =null,
    val type: String? =null,
    val pageURL: String? =null,
    val tags: String? =null,
    val previewURL: String? =null,
    val previewWidth: Int? =null,
    val previewHeight: Int? =null,
    val webformatURL: String? =null,
    val webformatWidth: Int? =null,
    val webformatHeight: Int? =null,
    val largeImageURL: String? =null,
    val imageWidth: Int? =null,
    val imageHeight: Int? =null,
    val imageSize: Int? =null,
    val views: Int? =null,
    val downloads: Int? =null,
    val collections: Int? =null,
    val likes: Int? =null,
    val comments: Int? =null,
    val userId: Int? =null,
    val user: String? =null,
    val userImageURL: String? =null
):Parcelable