package com.example.dreamdaddy.classes

import java.io.Serializable

/**
 * This enum establishes what kind of role has the SugarDaddy user.
 * @since November 2019
 */
enum class KindDaddy { INTELLECTUAL, BADDY, BEAR, MODERN, SPORTY, SOPHISTICATED, GOTHIC, OTHER }

/**
 * The SugarDaddy class represents an a kind of user who uses the app. This person has an interest in other SugarBabies.
 * This class inherits from the Person class. The class is Serializable.
 * @since November 2019
 */
class SugarDaddy : Person(), Serializable {

    private var money: Int = 0 // How much money the user handles
    var kind: KindDaddy = KindDaddy.GOTHIC // A predefined role for the SugarBaby. It can be changed later while registering.

    /**
     * Gets or sets how much money can handle the a SugarDaddy user.
     * @return money How much money a SugarDaddy user can handle.
     * @since November 2019
     */
    fun getMoney(): Int {

        return money

    }

}


