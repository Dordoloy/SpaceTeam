package com.example.spaceteam.model

/**
 * Action to be realised by user
 *
 * @param sentence: String, sentence that indicate what user is supposed to do
 * @param uiElement: UIElement, Element who is supposed to be actioned by uer
 * @param time: Long, by default : 8000 ms, limit time to do the action
 */
data class Action(
    val sentence: String,
    val uiElement: UIElement,
    val time: Long = 8000
)