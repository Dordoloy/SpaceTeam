package com.example.spaceteam.model

/**
 * Enum of state
 *
 * @param value: Int, value of state
 */
enum class State(val value: Int) {
    /**
     * state waiting : 0
     */
    WAITING(0),
    /**
     * state ready : 1
     */
    READY(1),
    /**
     * state in game (the game is running) : 2
     */
    IN_GAME(2),
    /**
     * Game over : 3
     */
    OVER(3)
}