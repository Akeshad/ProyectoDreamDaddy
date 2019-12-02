package com.example.dreamdaddy.classes

import java.io.Serializable

/**
 * This enum establishes what kind of role has the SugarBaby user.
 * @since November 2019
 */
enum class KindBaby { OTTER, SPOILED, FANCY, CUB, CHUB, ROMANTIC, EMO, OTHER }

/**
 * The SugarBaby class represents an a kind of user who uses the app. This person has an interest in other SugarDaddies.
 * This class inherits from the Person class. The class is Serializable.
 * @since November 2019
 */
class SugarBaby : Person(), Serializable {

    private var caresAboutMoney: Boolean = true // The user's care about how much money a SugarDaddy handles
    var kind: KindBaby = KindBaby.SPOILED // A predefined role for the SugarBaby. It can be changed later while registering.

    /**
     * Gets or sets if the SugarBaby cares about how much money a SugarDaddy handles.
     * @return true if the SugarBaby cares | false if the the SugarBaby doesn't care.
     * @since November 2019
     */
    fun caresAboutMoney(): Boolean {

        return caresAboutMoney

    }

}
