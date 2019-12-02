package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R

/**
 * The MainActivity class is the beginning and launching Activity of this app. It extends from AppCompatActivity class as it's necessary in order to work.
 * An user can choose here either to log in or to register.
 * @since November 2019
 */
class MainActivity : AppCompatActivity() {

    /**
     * Mandatory function invoked when creating the MainActivity (the launching one).
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

    }

    /**
     * Allows the transit from the MainActivitity (the launching one) to the LoginActivity.
     * This function also continues the App Cycle by going to the LoginActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun login(view: View) {

        val intent = Intent(this, LoginActivity::class.java)
        this.startActivity(intent)

    }

    /**
     * Allows the transit from the MainActivitity (the launching one) to the RoleSelectionActivity.
     * This function also continues the App Cycle by going to the RoleSelectionActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun register(view: View) {

        val intent = Intent(this, RoleSelectionActivity::class.java)
        this.startActivity(intent)

    }

}
