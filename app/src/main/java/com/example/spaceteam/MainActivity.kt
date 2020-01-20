package com.example.spaceteam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.spaceteam.model.UserPost
import com.example.spaceteam.serviceWeb.SpaceTeamService

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

        SpaceTeamService.registerUser(UserPost("Test_threeee"))

    }
}
