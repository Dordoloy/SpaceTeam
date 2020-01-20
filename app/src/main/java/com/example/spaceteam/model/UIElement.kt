package com.example.spaceteam.model

/**
 * UIElement class
 *
 * @param type: UIType, Type of uielement
 *
 * @return IElement
 */
sealed class UIElement(val type: UIType) : IElement {
    /**
     * Simple button to press
     *
     * @param id:Int, id of button
     * @param content:String text of button
     *
     * @return UIElement of type BUTTON
     */
    data class Button(override var id: Int, override val content: String) : UIElement(UIType.BUTTON)

    /**
     * switch element
     *
     * @param id:Int id of switch
     * @param content:String text of switch
     *
     * @return UIElement of type SWITCH
     */
    data class Switch(override var id: Int, override val content: String) : UIElement(UIType.SWITCH)

    /**
     * Shake action (shack the phone)
     *
     * @param id:Int id of shack element
     * @param content: String Shack text
     *
     * @return UIElement of type SHAKE
     */
    data class Shake(override var id: Int, override val content: String) : UIElement(UIType.SHAKE)
}

/**
 * UIType class, type of UIElement
 */
enum class UIType {
    /**
     * BUTTON, element type of button
     */
    BUTTON,
    /**
     * SWITCH, element type of switch
     */
    SWITCH,
    /**
     * SHAKE, element type of shake
     */
    SHAKE
}

/**
 * Element interface
 */
interface IElement {
    /**
     * id of element
     */
    var id: Int
    /**
     * text of element
     */
    val content: String
}