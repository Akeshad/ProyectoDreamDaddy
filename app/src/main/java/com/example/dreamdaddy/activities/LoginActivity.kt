package com.example.dreamdaddy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.dreamdaddy.R
import com.google.firebase.auth.FirebaseAuth

/**
 * The LoginActivity class is where the user can log in. He must write his email and password.
 * If the login is successful, the user will go to the GridActivity.
 * @since December 2019
 */
class LoginActivity : AppCompatActivity() {

    private val email by lazy { findViewById<EditText>(R.id.editTextUsernameLogin) } // User's username input
    private val password by lazy { findViewById<EditText>(R.id.editTextPasswordLogin) } // User's password input

    private val context = this // This Activity's context
    private val authentication = FirebaseAuth.getInstance() // Cloud Firestore Authentication

    /**
     * Mandatory function invoked when creating the LoginActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since December 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

    }

    /**
     * Allows the connection to the Cloud Firestore in order to check if the input data exists as the user stated.
     * If it is successful, the user will log in and continue to the GridActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since December 2019
     */
    fun loginUser(view: View) {

        authentication.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener { task ->

            if (task.isSuccessful) {

                val user = authentication.getCurrentUser()

                val intent = Intent(this, GridActivity::class.java)
                this.startActivity(intent)

            } else {

                Toast.makeText(context, resources.getString(R.string.loginFailure), Toast.LENGTH_LONG).show()

            }

        }

    }

}
