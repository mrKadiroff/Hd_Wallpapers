package com.example.rasmlar.retrofit

import com.example.rasmlar.modules.Photo
import com.example.rasmlar.modules.WallpaperResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {


    @GET("search/photos")
    fun getListWallpaper
                (@Query("query") query: String,
                 @Query("client_id") key:String
    ): Call<Photo>




}