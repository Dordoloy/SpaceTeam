package com.example.spaceteam

/**
 * Configuration resources of the project
 *
 */
object Config {
    /**
     * TAG used for filter list of log in debug
     */
    val TAG = "DEBUG-27"

    /**
     * server domain
     */
    val domain = "vps769278.ovh.net"
    /**
     * Base of Web Socket URL
     */
    val socketURL = "ws://$domain:8081/ws"

    /**
     * API URL in http, for abort mistakes with socketURL
     */
    val ApiURL = "http://$domain"
}
