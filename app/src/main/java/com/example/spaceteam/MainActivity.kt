package com.example.spaceteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast







/**
 * Main class point of enter of programme
 */
class MainActivity : AppCompatActivity() {

    /**
     * called in the creation of the application
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG-27", "main")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
    }

}
