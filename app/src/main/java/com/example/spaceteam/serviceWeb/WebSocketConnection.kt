package com.example.spaceteam.serviceWeb

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.spaceteam.Config
import com.example.spaceteam.model.Event
import com.example.spaceteam.model.EventType
import com.example.spaceteam.model.UIElement
import com.example.spaceteam.model.UIType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*

/**
 * Class of Web Socket Connection
 *
 */
object WebSocketConnection {

    /**
     * Client OkHttp
     */
    val clientWebSocket = OkHttpClient()

    /**
     * Live data of Event
     */
    val lastEventReceived = MutableLiveData<Event>()

    /**
     * Tell to the server the player is ready
     *
     * @param webSocket: WebSocket, instance of web socket
     */
    fun sayPlayerReady(webSocket: WebSocket) {
        webSocket.send(parser.toJson(Event.Ready(true)))
    }

    /**
     * Tell to the server what player do on UI
     *
     * @param uiElement: UIElement, the UI element the player actioned
     */
    fun makeAction(webSocket: WebSocket, uiElement: UIElement) {
        webSocket.send(parser.toJson(Event.PlayerAction(uiElement)))
    }

    /**
     * Function called for add a player to a room
     *
     * @param roomName:String Name of the room the user would join
     * @param userId:Int Id of the user
     *
     * @return an instance of webSocket
     */
    fun joinRoom(roomName: String, userId: Int): WebSocket {


        /**
         * instance od web socket
         */
        var webSocket = clientWebSocket.newWebSocket(
            Request.Builder().url(Config.socketURL + "/join/$roomName/$userId").build(),
            object : WebSocketListener() {

                /**
                 * Function for open the connection
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param response:Response The response of the server with the connection status
                 */
                override fun onOpen(
                    webSocket: WebSocket,
                    response: Response
                ) {
                    Log.d(Config.TAG, "Connection to web socket is open")
                }

                /**
                 * Function occur when the server send a response message as string
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param text:String The message text sending by the server
                 */
                override fun onMessage(webSocket: WebSocket, text: String) {
                    val event = parser.fromJson(text)
                    lastEventReceived.postValue(event)

                    Log.d(Config.TAG, "Receive message from socket : ${event.toString()}")
                }


                /**
                 * Function occur when the connection is closing
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param code:Int Code of the closing reason
                 * @param reason:String Message of the reason for connection closing
                 */
                override fun onClosing(
                    webSocket: WebSocket,
                    code: Int,
                    reason: String
                ) {
                    webSocket.close(1000, "Session time finish")
                    webSocket.cancel()
                    Log.d(
                        Config.TAG,
                        "The web socket connection will be closed soon with code : $code for reason : $reason"
                    )
                }

                /**
                 * Function occur when the connection is closing
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param code:Int Code of the closing reason
                 * @param reason:String Message of the reason for connection closing
                 */
                override fun onClosed(
                    webSocket: WebSocket,
                    code: Int,
                    reason: String
                ) {
                    Log.d(
                        Config.TAG,
                        "The web socket connection has been closed with code : $code and reason : $reason"
                    )
                }

                /**
                 * Function occur when an error append during the connection
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param t:Throwable
                 * @param response:Response The response with the connection error. It's could be null
                 */
                override fun onFailure(
                    webSocket: WebSocket,
                    t: Throwable,
                    response: Response?
                ) {
                    Log.d(
                        Config.TAG,
                        "Web socket connection fail : ${response.toString()},  ${t.message}"
                    )
                }
            })
        return webSocket
    }

    /**
     * Moshi's parser for convert JSON ans Kotlin classes
     */
    var parser = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(Event::class.java, "type")
                .withSubtype(Event.WaitingForPlayer::class.java, EventType.WAITING_FOR_PLAYER.name)
                .withSubtype(Event.NextAction::class.java, EventType.NEXT_ACTION.name)
                .withSubtype(Event.GameStarted::class.java, EventType.GAME_STARTED.name)
                .withSubtype(Event.GameOver::class.java, EventType.GAME_OVER.name)
                .withSubtype(Event.NextLevel::class.java, EventType.NEXT_LEVEL.name)
                .withSubtype(Event.Error::class.java, EventType.ERROR.name)
                .withSubtype(Event.Ready::class.java, EventType.READY.name)
                .withSubtype(Event.PlayerAction::class.java, EventType.PLAYER_ACTION.name)
        )
        .add(
            PolymorphicJsonAdapterFactory.of(UIElement::class.java, "type")
                .withSubtype(UIElement.Switch::class.java, UIType.SWITCH.name)
                .withSubtype(UIElement.Shake::class.java, UIType.SHAKE.name)
                .withSubtype(UIElement.Button::class.java, UIType.BUTTON.name)
        )
        .add(KotlinJsonAdapterFactory())
        .build().adapter<Event>(Event::class.java)
}