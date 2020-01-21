package com.example.spaceteam.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.spaceteam.model.Event
import com.example.spaceteam.serviceWeb.WebSocketConnection

/**
 * View of game
 *
 * @param webSocketListener: WebSocketConnection Connection to the webSocket
 */
class GameViewModel: ViewModel() {


    /**
     * Observe the modification on live data
     */
    private val _event = WebSocketConnection.lastEventReceived

    val event: LiveData<Event>
        get() {
            return _event
        }

}
