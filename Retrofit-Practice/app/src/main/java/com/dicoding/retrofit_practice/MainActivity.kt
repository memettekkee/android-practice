package com.dicoding.retrofit_practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.retrofit_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}