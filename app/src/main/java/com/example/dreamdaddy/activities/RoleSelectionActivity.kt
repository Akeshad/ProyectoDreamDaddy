package com.example.dreamdaddy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dreamdaddy.R

/**
 * The RoleSelectionActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * An user can choose here either if he's a SugarDaddy or a SugarBaby.
 * @since November 2019
 */
class RoleSelectionActivity : AppCompatActivity() {

    /**
     * Mandatory function invoked when creating the RoleSelectionActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_role_selection)

    }

    /**
     * Allows the transit from the RoleSelectionActivity to the RoleSugarDaddyActivity.
     * This function also continues the App Cycle by going to the RoleSugarDaddyActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun sugarDaddyRole(view: View) {

        val intent = Intent(this, RoleSugarDaddyActivity::class.java)
        this.startActivity(intent)

    }

    /**
     * Allows the transit from the RoleSelectionActivity to the RoleSugarBabyActivity.
     * This function also continues the App Cycle by going to the RoleSugarBabyActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun sugarBabyRole(view: View) {

        val intent = Intent(this, RoleSugarBabyActivity::class.java)
        this.startActivity(intent)

    }

}
