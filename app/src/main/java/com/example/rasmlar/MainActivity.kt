package com.example.rasmlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import retrofit2.Callback
import com.example.rasmlar.databinding.ActivityMainBinding
import com.example.rasmlar.modules.Photo
import com.example.rasmlar.modules.WallpaperResult
import com.example.rasmlar.retrofit.Common
import com.example.rasmlar.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var retrofitService: RetrofitService
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)



    }
}