package com.example.spaceteam.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.spaceteam.Config
import com.example.spaceteam.model.User
import com.example.spaceteam.serviceWeb.SpaceTeamService
import com.squareup.moshi.Types
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * score view
 */
class ScoreViewModel : ViewModel() {

    /**
     * Get the user list for display all scores
     */
    fun GetUerList(): List<User>? {

        var userList: List<User>? = null

        SpaceTeamService.retrofit.userList().enqueue(object : Callback<List<User>?> {

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                Log.d(Config.TAG, "Sorry yout registration has failed. Message : " + t.message)
            }

            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                userList = SpaceTeamService.moshi.adapter<List<User>>(
                    Types.newParameterizedType(
                        List::class.java,
                        User::class.java
                    )
                ).fromJson(response.body().toString())
            }
        })
        return userList
    }

}