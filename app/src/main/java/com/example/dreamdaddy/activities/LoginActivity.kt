package com.example.dreamdaddy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.dreamdaddy.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {

    private val email by lazy { findViewById<EditText>(R.id.editTextUsernameLogin) } // User's username input
    private val password by lazy { findViewById<EditText>(R.id.editTextPasswordLogin) } // User's password input

    private val myFirebase = FirebaseFirestore.getInstance() // Cloud Firestore DB
    private val authentication = FirebaseAuth.getInstance() // Cloud Firestore Authentication

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

    }

    fun loginUser(view: View) {

        val estaActividad = this
        val auth = FirebaseAuth.getInstance()

        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener(this, OnCompleteListener { task ->

            if (task.isSuccessful) {

                val user = auth.getCurrentUser()
                Toast.makeText(estaActividad, user?.email + " : " + user?.uid, Toast.LENGTH_LONG).show()
                val intent = Intent(this, GridActivity::class.java)
                this.startActivity(intent)

            } else {

                Toast.makeText(estaActividad, "Error Iniciando sesión", Toast.LENGTH_LONG).show()
            }
        })

    }

}
