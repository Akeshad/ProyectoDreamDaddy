package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarDaddy
import com.example.dreamdaddy.classes.kindDaddy

class RoleSugarDaddyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sugar_daddy_role)
    }

    fun createNewDaddyIntellectual(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.INTELLECTUAL

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

    fun createNewDaddyBaddy(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.BADDY

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

    fun createNewDaddyBear(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.BEAR

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

    fun createNewDaddyModern(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.MODERN

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

    fun createNewDaddySporty(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.SPORTY

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

    fun createNewDaddySophisticated(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.SOPHISTICATED

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

    fun createNewDaddyGothic(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.GOTHIC

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

    fun createNewDaddyOther(view: View) {
        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.OTHER

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)
    }

}