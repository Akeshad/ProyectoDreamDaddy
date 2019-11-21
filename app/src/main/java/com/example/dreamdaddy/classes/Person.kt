package com.example.dreamdaddy.classes

import android.widget.ImageView
import java.io.Serializable
import java.time.LocalDate
import java.util.*

open class Person : Serializable {
    var nickname: String = ""
    var password: String = ""
    var linkImage: Int = 0
    lateinit var birthDate: LocalDate
    var email: String = ""
    var telephone: String = ""
}
