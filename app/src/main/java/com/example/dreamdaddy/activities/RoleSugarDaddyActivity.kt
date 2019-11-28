package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarDaddy
import com.example.dreamdaddy.classes.kindDaddy

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
     * Click event that creates a SugarDaddy Object with a kindDaddy.INTELLECTUAL and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyIntellectual(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.INTELLECTUAL
        sugarDaddy.linkImage = R.drawable.prueba

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a kindDaddy.BADDY and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyBaddy(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.BADDY
        // TODO IMAGEN DEL BADDY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a kindDaddy.BEAR and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyBear(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.BEAR
        // TODO IMAGEN DEL BEAR. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a kindDaddy.MODERN and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyModern(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.MODERN
        // TODO IMAGEN DEL MODERN. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a kindDaddy.SPORTY and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddySporty(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.SPORTY
        // TODO IMAGEN DEL SPORTY. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a kindDaddy.SOPHISTICATED and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddySophisticated(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.SOPHISTICATED
        // TODO IMAGEN DEL SOPHISTICATED. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a kindDaddy.GOTHIC and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyGothic(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.GOTHIC
        // TODO IMAGEN DEL GOTHIC. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarDaddy Object with a kindDaddy.OTHER and predefined avatar image bound to said Object.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewDaddyOther(view: View) {

        val sugarDaddy = SugarDaddy()
        sugarDaddy.kind = kindDaddy.OTHER
        // TODO IMAGEN DEL OTHER. PROCESAR Y LINKEAR EN ESTA LINEA

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugardaddy", sugarDaddy)
        startActivity(intent)

    }

}