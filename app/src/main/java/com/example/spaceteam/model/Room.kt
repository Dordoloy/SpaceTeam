package com.example.spaceteam.model

/**
 * Class of a room (waiting room with player)
 *
 * @param name: String, Name of room
 * @param state:State state of room
 * @param initialNumberOfUser: Int, number of user
 * @param userList: List<User>, List of user in room
 */
data class Room(
    var name: String,
    var state: State,
    var initialNumberOfUser: Int,
    var userList: List<User>
)

data class RoomList(var room: List<Room>)