package com.example.spaceteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG-27", "main")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
