package com.example.spaceteam.screens.game

import androidx.lifecycle.LiveData
import com.example.spaceteam.model.Event
import com.example.spaceteam.serviceWeb.WebSocketConnection

/**
 * View of game
 *
 * @param webSocketListener: WebSocketConnection Connection to the webSocket
 */
class GameViewModel(val webSocketListener: WebSocketConnection) {

    /**
     * Observe the modification on live data
     */
    fun getLastEventReceived() : LiveData<Event> = webSocketListener.lastEventReceived


}
