package com.example.dreamdaddy.classes

import java.io.Serializable
import java.util.*

/**
 * The Person class represents an abstract person who uses the app (an user not defined as a SugarDaddy nor SugarBaby yet).
 * The idea is this class to be the super class for the inheritors classes: SugarDaddy and SugarBaby.
 * The class is Serializable.
 * @since November 2019
 */
open class Person : Serializable {

    var nickname: String = "" // The user's nickname
    var password: String = "" // The user's password
    var linkImage: Int = 0 // The user's avatar
    lateinit var birthDate: Calendar // The user's birth date
    var email: String = "" // The user's email
    var telephone: String = "" // The user's telephone

}
