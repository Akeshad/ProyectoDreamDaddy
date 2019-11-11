package com.example.dreamdaddy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import com.example.dreamdaddy.R

class RoleSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_role_selection)
    }

    fun sugarDaddyRole(view: View) {
        var intent: Intent = Intent(this, RoleSugarDaddyActivity::class.java)
        this.startActivity(intent)
    }

    fun sugarBabyRole(view: View) {
        var intent: Intent = Intent(this, RoleSugarBabyActivity::class.java)
        this.startActivity(intent)
    }
}
