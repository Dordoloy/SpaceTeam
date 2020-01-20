package com.example.spaceteam.model

/**
 * Event who could be occurred in game
 *
 * @param type: EventType, type of event thrown
 */
sealed class Event(val type: EventType) {
    /**
     * Do the next action in game
     *
     * @param action: Action, next action who need to be donne
     *
     * @return Event of type NEXT_ACTION
     */
    data class NextAction(val action: Action) : Event(EventType.NEXT_ACTION)

    /**
     * Event when a new game is started
     *
     * @param uiElementList: List<UIElement> List of element display in screen
     *
     * @return Event of type GAME_STARTED
     */
    data class GameStarted(val uiElementList: List<UIElement>) : Event(EventType.GAME_STARTED)

    /**
     * Event when game is over for win or lose
     *
     * @param score:Int, scor of player
     * @param win:Boolean, if true the team have win the game
     * @param level:Int, the last level they played
     *
     * @return Event of type GAME_OVER
     */
    data class GameOver(val score: Int, val win: Boolean, val level: Int) :
        Event(EventType.GAME_OVER)

    /**
     * Event when the team go on the next level
     *
     * @param uiElementList: List<UIElement>, UIElement list who need to be displayed
     * @param level: Int, new level
     *
     * @return Event of type NEXT_LEVEL
     */
    data class NextLevel(val uiElementList: List<UIElement>, val level: Int) :
        Event(EventType.NEXT_LEVEL)

    /**
     * The room is waiting for players
     *
     * @param userList: List<User> the list of current user in the room
     *
     * @return Event of type WAITING_FOR_PLAYER
     */
    data class WaitingForPlayer(val userList: List<User>) : Event(EventType.WAITING_FOR_PLAYER)

    /**
     * An error is appear
     *
     * @param message: String, the message of error
     *
     * @return Event
     */
    data class Error(val message: String) : Event(EventType.ERROR)

    /**
     * The game is ready to start
     *
     */
    data class Ready(val value: Boolean) : Event(EventType.READY)

    /**
     * The user have donne something
     *
     */
    data class PlayerAction(val uiElement: UIElement) : Event(EventType.PLAYER_ACTION)
}

/**
 * List of enum of event
 */
enum class EventType {
    /**
     * Game is started
     */
    GAME_STARTED()

    /**
     * Game is over
     */
    ,
    GAME_OVER()

    /**
     * An error is appear
     */
    ,
    ERROR()

    /**
     * The game is ready to be played
     */
    ,
    READY()

    /**
     * Next action to be donne
     */
    ,
    NEXT_ACTION()

    /**
     * Next level
     */
    ,
    NEXT_LEVEL()

    /**
     * The room is waiting players
     */
    ,
    WAITING_FOR_PLAYER()

    /**
     * Action to be donne by the player
     */
    ,
    PLAYER_ACTION()
}