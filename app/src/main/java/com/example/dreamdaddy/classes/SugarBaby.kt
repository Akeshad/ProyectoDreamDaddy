package com.example.dreamdaddy.classes

import java.io.Serializable

enum class kindBaby {
        OTTER, SPOILED, FANCY, CUP, CHUB, ROMANTIC, EMO, OTHER
}
class SugarBaby : Person(), Serializable {

    private var caresAboutMoney: Boolean = true
    var kind: kindBaby = kindBaby.SPOILED

    fun caresAboutMoney(): Boolean { return caresAboutMoney }

}
