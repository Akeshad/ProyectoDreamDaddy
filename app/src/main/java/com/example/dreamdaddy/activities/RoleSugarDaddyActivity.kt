package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarDaddy
import com.example.dreamdaddy.classes.KindDaddy

/**
 * The RoleSugarDaddyActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After choosing to be a SugarDaddy in the RoleSelectionActivity class, an user can choose here which kind of SugarDaddy represents him at best.
 * @since November 2019
 */
class RoleSugarDaddyActivity : AppCompatActivity() {

    /**
     * Mandatory function invoked when creating the RoleSugarDaddyActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sugar_daddy_role)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.INTELLECTUAL and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyIntellectual(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.INTELLECTUAL
        sugarDaddy.linkImage = R.drawable.daddy_intellectual

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.BADDY and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyBaddy(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.BADDY
        sugarDaddy.linkImage = R.drawable.daddy_baddy

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.BEAR and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyBear(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.BEAR
        sugarDaddy.linkImage = R.drawable.daddy_bear

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.MODERN and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyModern(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.MODERN
        sugarDaddy.linkImage = R.drawable.daddy_modern

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.SPORTY and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddySporty(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.SPORTY
        sugarDaddy.linkImage = R.drawable.daddy_sporty

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.SOPHISTICATED and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddySophisticated(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.SOPHISTICATED
        sugarDaddy.linkImage = R.drawable.daddy_sophisticated

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.GOTHIC and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyGothic(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.GOTHIC
        sugarDaddy.linkImage = R.drawable.daddy_gothic

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a KindDaddy.OTHER and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyOther(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = KindDaddy.OTHER
        sugarDaddy.linkImage = R.drawable.daddy_other

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

}