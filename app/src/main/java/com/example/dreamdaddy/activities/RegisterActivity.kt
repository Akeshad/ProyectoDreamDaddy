package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import java.sql.Date

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)
    }

    fun subscribeNewUser(view: View) {

        val sugarDaddy : SugarDaddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy
       // val sugarBaby : SugarBaby? = intent.getSerializableExtra("sugarbaby") as SugarBaby


        if(sugarDaddy != null) {
            sugarDaddy.nickname = findViewById<EditText>(R.id.editTextUsernameRegister).text.toString()
            sugarDaddy.email = findViewById<EditText>(R.id.editTextEmailRegister).text.toString()
            sugarDaddy.password = findViewById<EditText>(R.id.editTextPasswordRegister).text.toString()
            sugarDaddy.birthDate = findViewById<EditText>(R.id.editTextBirthDateRegister).text as Date
            val intent = Intent(this, GridActivity::class.java)
            intent.putExtra("sugardaddy", sugarDaddy)
            startActivity(intent)
        }

     /*  if(sugarBaby != null){
            sugarBaby.nickname = findViewById<EditText>(R.id.editTextUsernameRegister).text.toString()
            sugarBaby.email = findViewById<EditText>(R.id.editTextEmailRegister).text.toString()
            sugarBaby.password = findViewById<EditText>(R.id.editTextPasswordRegister).text.toString()
            sugarBaby.birthDate = findViewById<EditText>(R.id.editTextBirthDateRegister).text as Date
        }*/
    }
}