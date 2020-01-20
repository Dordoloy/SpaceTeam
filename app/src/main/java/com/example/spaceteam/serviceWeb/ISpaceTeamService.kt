package com.example.spaceteam.serviceWeb

import com.example.spaceteam.Config
import com.example.spaceteam.model.RoomList
import com.example.spaceteam.model.User
import com.example.spaceteam.model.UserList
import com.example.spaceteam.model.UserPost
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
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
    fun userList(): Call<UserList>

    /**
     * Get detail of one user by is ID
     *
     * @param id:Int the user id
     *
     * @return User? the user of id
     */
    @GET("/api/user/{id}")
    fun logUserById(@Path("id") id: Int): Call<User>

    /**
     * Log a new user on the server by a login
     *
     * @param userPostJon:String the name of the new user
     *
     * @return the id of new user
     */
    @POST("/api/user/register")
    fun registerUser(@Body userPostJon: String): Call<User>

    /**
     * Get the list of amiable room
     *
     * @return List<Room>? the list of all room existed in the server
     */
    @GET("/show")
    fun roomList(): Call<RoomList>

}





/**
 * Get an instance of server for use different functions
 */
object SpaceTeamService {

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    /**
     * Object is an build instance of Retrofit service all configured
     */
    val retrofit = Retrofit.Builder()
        .baseUrl("http://" + Config.domain)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okhttp3.OkHttpClient())
        .build()
        .create(ISpaceTeamService::class.java)


    /**
     * Log a new user on the server by a login and convert the UserPost object to json
     *
     * @param newUser:UserPost the name of the new user
     *
     * @return the id of new user
     */
    fun registerUser(userPost: UserPost): Call<User> {
        return retrofit.registerUser(
            Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(UserPost::class.java).toJson(
                userPost
            )
        )
    }


}



