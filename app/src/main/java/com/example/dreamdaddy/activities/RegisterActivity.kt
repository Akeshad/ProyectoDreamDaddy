package com.example.dreamdaddy.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)
    }

    fun subscribeNewUser(view: View) {

        val sugarDaddy = intent.getSerializableExtra("sugardaddy")

    }
}