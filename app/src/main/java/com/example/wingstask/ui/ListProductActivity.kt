package com.example.wingstask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wingstask.databinding.ActivityListProductBinding

class ListProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}