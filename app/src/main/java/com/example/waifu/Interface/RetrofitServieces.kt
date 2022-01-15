package com.example.waifu.Interface

import com.example.waifu.Model.Image
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("nsfw/hentai/?many=true")
    fun getImageList(): Call<Image>
}