package com.example.waifu.Common

import com.example.waifu.Interface.RetrofitServices
import com.example.waifu.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://api.waifu.im/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}