package com.example.waifu.Model

data class Picture(
    var url: String? = null,
    var description: String? = null,
)

data class Image(
    var images: List<Picture> = emptyList()
)