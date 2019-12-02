package com.example.dreamdaddy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.KindBaby

/**
 * The RoleSugarBabyActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After choosing to be a SugarBaby in the RoleSelectionActivity class, an user can choose here which kind of SugarBaby represents him at best.
 * @since November 2019
 */
class RoleSugarBabyActivity : AppCompatActivity() {

    /**
     * Mandatory function invoked when creating the RoleSugarBabyActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sugar_baby_role)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.OTTER and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabyOtter(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.OTTER
        sugarBaby.linkImage = R.drawable.baby_otter

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.SPOILED and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabySpoiled(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.SPOILED
        sugarBaby.linkImage = R.drawable.baby_spoiled

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.FANCY and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabyFancy(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.FANCY
        sugarBaby.linkImage = R.drawable.baby_fancy

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.CUP and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabyCub(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.CUB
        sugarBaby.linkImage = R.drawable.baby_cub

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.CHUB and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabyChub(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.CHUB
        sugarBaby.linkImage = R.drawable.baby_chub

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.ROMANTIC and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabyRomantic(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.ROMANTIC
        sugarBaby.linkImage = R.drawable.baby_romantic

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.EMO and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabyEmo(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.EMO
        sugarBaby.linkImage = R.drawable.baby_emo

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

    /**
     * Click event that creates a SugarBaby Object with a KindBaby.OTHER and predefined avatar image bound to said Object.
     * This function also continues the App Cycle by going to the RegisterActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun createNewBabyOther(view: View) {

        val sugarBaby = SugarBaby()
        sugarBaby.kind = KindBaby.OTTER
        sugarBaby.linkImage = R.drawable.baby_other

        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("sugarbaby", sugarBaby)
        startActivity(intent)

    }

}