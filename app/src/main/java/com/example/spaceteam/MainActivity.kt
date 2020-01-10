package com.example.spaceteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG-27", "main")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
