package com.example.spaceteam.model

data class Room(
    var name: String,
    var state: State,
    var initialNumberOfUser: Int,
    var userList: List<User>
)