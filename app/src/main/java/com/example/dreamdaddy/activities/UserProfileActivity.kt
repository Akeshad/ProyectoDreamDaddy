package com.example.dreamdaddy.activities

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R

/**
 * The UserProfileActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After logging in or registering, an user can change different options regarding his own profile.
 * @since November 2019
 */
class UserProfileActivity : AppCompatActivity() {

    private val selectOperation by lazy { findViewById<Spinner>(R.id.user_options) }

    /**
     * Mandatory function invoked when creating the UserProfileActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_user_profile)

        val operations = arrayOf("Teléfono", "Nickname", "Sueldo anual", "Contraseña")
        val adapter = ArrayAdapter<String>(this, R.layout.elemts_spinner_user_options, operations)

        selectOperation.adapter = adapter

    }

    /**
     * Event function invoked when pressing the Activity's button. The main goal is to select which option the user wants to modify.
     * Then, he writes the information in the EditText and, afterwards, he only must press said button to save the changes.
     * @param view If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    fun saveChanges(view: View) {

        when (this.selectOperation.selectedItem.toString()) {

            "Teléfono" -> {



            }

            "Nickname" -> {



            }

            "Sueldo anual" -> {



            }

            "Contraseña" -> {



            }

        }

    }

}