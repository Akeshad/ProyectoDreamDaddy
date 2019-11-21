package com.example.dreamdaddy.classes

import java.io.Serializable
import java.util.*

open class Person : Serializable {
    var nickname: String = ""
    var password: String = ""
    var linkImage: Int = 0
    lateinit var birthDate: Calendar
    var email: String = ""
    var telephone: String = ""
}
