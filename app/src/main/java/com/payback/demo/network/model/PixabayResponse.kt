package com.payback.demo.network.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PixabayResponse(
    var total: Int,
    var totalHits: Int,
    var hits: List<NetworkImageListItem>

)