package com.example.dreamdaddy.classes

import java.io.Serializable

class SugarDaddy : Person(), Serializable {

    var money: Int = 0
    var kind: kindDaddy = kindDaddy.GOTHIC
}

enum class kindDaddy {
    INTELLECTUAL, BADDY, BEAR, MODERN, SPORTY, SOPHISTICATED, GOTHIC, OTHER
}
