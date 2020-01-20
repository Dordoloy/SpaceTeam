package com.example.spaceteam.model

/**
 * User class
 */
data class User(
    /**
     * id of user
     */
    val id: Int,
    /**
     * name of user
     */
    val name: String,
    /**
     * path of user avatar
     */
    val avatar: String,
    /**
     * score of user
     */
    var score: Int,
    /**
     * state of user by default OVER
     */
    var state: State = State.OVER
)

/**
 * data class for register a user
 *
 * @param name:String, name of user
 */
data class UserPost(val name: String)
