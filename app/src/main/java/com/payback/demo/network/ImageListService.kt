package com.payback.demo.network

import com.payback.demo.network.model.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageListService {

    @GET("api/?key=26245369-ef4ad4c59dcf0e1a0739c4a46&pretty=true&image_type=photo")
    suspend fun getImageList(@Query("q") search_query:String): PixabayResponse
}