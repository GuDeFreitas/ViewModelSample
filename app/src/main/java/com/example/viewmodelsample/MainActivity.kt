package com.example.viewmodelsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MyViewModel by viewModels{MyViewModel.Factory}

        val tvCounter = findViewById<TextView>(R.id.tv_counter)
        val btnCounter = findViewById<TextView>(R.id.btn_counter)

        tvCounter.text = viewModel.getCount().toString()
        btnCounter.setOnClickListener {
            viewModel.incrementOne()
            tvCounter.text = viewModel.getCount().toString()
        }
    }
}