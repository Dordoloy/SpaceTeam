package com.example.spaceteam.model

data class User(
    val id: Int,
    val name: String,
    val avatar: String,
    var score: Int,
    var state: State = State.OVER
)

data class UserPost(val name: String)
