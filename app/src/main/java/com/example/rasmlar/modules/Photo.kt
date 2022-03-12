package com.example.rasmlar.modules

data class Photo(
    val results: List<WallpaperResult>,
    val total: Int,
    val total_pages: Int
)