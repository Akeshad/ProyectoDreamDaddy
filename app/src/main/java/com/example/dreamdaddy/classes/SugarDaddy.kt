package com.example.dreamdaddy.classes

import java.io.Serializable

enum class kindDaddy {
    INTELLECTUAL, BADDY, BEAR, MODERN, SPORTY, SOPHISTICATED, GOTHIC, OTHER
}

class SugarDaddy : Person(), Serializable {

    private var money: Int = 0
    var kind: kindDaddy = kindDaddy.GOTHIC

    fun getMoney(): Int { return money }

}


