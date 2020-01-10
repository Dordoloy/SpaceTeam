package com.example.spaceteam.serviceWeb

import com.example.spaceteam.model.Room
import com.example.spaceteam.model.User
import com.example.spaceteam.model.UserPost
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/*
**
*
*
*
 */
interface ISpaceTeamService {

    /*
    **
    *
    *
     */
    @GET("/api/users")
    fun userList(): List<User>?

    /*
    **
    *
    *
     */
    @GET("/api/user/{id}")
    fun logUserById(@Path("id") id: Int): User?

    /*
    **
    *
    *
     */
    @POST("/api/user/register")
    fun registerUser(@Body newUser: UserPost)

    /*
    **
    *
    *
    *
     */
    @GET("/show")
    fun roomList(): List<Room>?

}