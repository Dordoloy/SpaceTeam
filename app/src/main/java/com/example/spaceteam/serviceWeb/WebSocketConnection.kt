package com.example.spaceteam.serviceWeb

import android.util.Log
import com.example.spaceteam.Config
import okhttp3.*
import okio.ByteString

/**
 * Class of Web Socket Connection
 *
 */
class WebSocketConnection {

    /**
     * Client OkHttp
     *
     */
    val clientWebSocket = OkHttpClient()

    /**
     * Function that test the connection to the server
     *
     */
    fun testConnection() {

        // Instance of the web socket
        clientWebSocket.newWebSocket(
            Request.Builder().url(Config.baseURL).build(),
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
                    webSocket.send("")
                    Log.d(Config.TAG, "Connection to web socket is open")
                }

                /**
                 * Function occur when the server send a response message as string
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param text:String The message text sending by the server
                 */
                override fun onMessage(webSocket: WebSocket, text: String) {
                    Log.d(Config.TAG, "Receive message from socket : $text")
                }

                /**
                 * Function occur when the server send a response message as ByteString
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param bytes:ByteString The message text sending by the server
                 */
                override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                    Log.d(Config.TAG, "Receive message from socket : ${bytes.hex()}")
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
                    Log.d(Config.TAG, "Web socket connection fail : ${response.toString()}")
                }
            })

        clientWebSocket.dispatcher.executorService.shutdown()
    }

    /**
     * Function called for add a player to a room
     *
     * @param roomName:String Name of the room the user would join
     * @param userId:Int Id of the user
     */
    fun joinRoom(roomName: String, userId: Int) {

        // Instance of the web socket
        clientWebSocket.newWebSocket(
            Request.Builder().url(Config.baseURL + "join").build(),
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
                    webSocket.send("")
                    Log.d(Config.TAG, "Connection to web socket is open")
                }

                /**
                 * Function occur when the server send a response message as string
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param text:String The message text sending by the server
                 */
                override fun onMessage(webSocket: WebSocket, text: String) {
                    Log.d(Config.TAG, "Receive message from socket : $text")
                }

                /**
                 * Function occur when the server send a response message as ByteString
                 *
                 * @param webSocket:WebSocket the webSocket client
                 * @param bytes:ByteString The message text sending by the server
                 */
                override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                    Log.d(Config.TAG, "Receive message from socket : ${bytes.hex()}")
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
        clientWebSocket.dispatcher.executorService.shutdown()
    }
}