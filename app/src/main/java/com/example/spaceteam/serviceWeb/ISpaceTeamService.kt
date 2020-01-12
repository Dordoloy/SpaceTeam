package com.example.spaceteam.serviceWeb

import com.example.spaceteam.Config
import com.example.spaceteam.model.Room
import com.example.spaceteam.model.User
import com.example.spaceteam.model.UserPost
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


/**
 * Interface for get ans set data to the server
 *
 */
interface ISpaceTeamService {

    /**
     * Get all user on the server
     *
     * @return List<User>? the list of user connected
     */
    @GET("/api/users")
    fun userList(): List<User>?

    /**
     * Get detail of one user by is ID
     *
     * @param id:Int the user id
     * @return User? the user of id
     */
    @GET("/api/user/{id}")
    fun logUserById(@Path("id") id: Int): User?

    /**
     * Log a new user on the server by a login
     *
     * @param newUser:UserPost the name of the new user
     */
    @POST("/api/user/register")
    fun registerUser(@Body newUser: UserPost)

    /**
     * Get the list of amiable room
     *
     * @return List<Room>? the list of all room existed in the server
     */
    @GET("/show")
    fun roomList(): List<Room>?

}

var serviceSpaceTeam: ISpaceTeamService = Retrofit.Builder()
    .baseUrl("http://" + Config.domain)
    .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build())) // com.squareup.retrofit2:converter-moshi:latest.version
    .build()
    .create(ISpaceTeamService::class.java)
