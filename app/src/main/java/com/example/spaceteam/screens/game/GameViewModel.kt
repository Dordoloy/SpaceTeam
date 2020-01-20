package com.example.spaceteam.screens.game

import androidx.lifecycle.LiveData
import com.example.spaceteam.model.Event
import com.example.spaceteam.serviceWeb.WebSocketConnection

/**
 * View of game
 */
class GameViewModel(val webSocketListener: WebSocketConnection) {

    fun getLastEventReceived() : LiveData<Event> = webSocketListener.lastEventReceived


}
