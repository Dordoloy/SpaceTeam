package com.example.spaceteam.screens.score

import com.example.spaceteam.model.UserList
import com.example.spaceteam.serviceWeb.SpaceTeamService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * score view
 */
class ScoreViewModel {

    fun GetUerList() {
        SpaceTeamService.retrofit.userList().enqueue(object : Callback<UserList> {
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

}