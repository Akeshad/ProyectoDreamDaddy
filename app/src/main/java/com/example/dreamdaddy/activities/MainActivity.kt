package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
    }

    fun login(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
    fun register(view: View) {
        val intent = Intent(this, RoleSelectionActivity::class.java)
        this.startActivity(intent)
    }

}
