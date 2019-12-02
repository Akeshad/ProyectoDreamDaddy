package com.example.dreamdaddy.activities

import android.Manifest.permission.CALL_PHONE
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import java.text.DateFormat

/**
 * The SelectedProfileActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After choosing someone's profile from the GridActivity, the user can see the selected person's information.
 * @since November 2019
 */
class SelectedProfileActivity : AppCompatActivity() {

    private lateinit var daddy: SugarDaddy // If the user is a SugarDaddy
    private lateinit var baby: SugarBaby // If the user is a SugarBaby

    private val avatar by lazy { findViewById<ImageView>(R.id.imageViewSelectedProfile) } // Avatar of the selected profile
    private val textInfo by lazy { findViewById<TextView>(R.id.textViewSelectedProfile) } // Written data of the selected profile
    private val phoneButton by lazy { findViewById<ImageButton>(R.id.imageButtonPhoneSelectedProfile) } // Button for calling the selected profile

    private val callPermission: Array<String> = arrayOf(CALL_PHONE)
    private val callPermissionCode = 100

    /**
     * Mandatory function invoked when creating the SelectedProfileActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_selected_profile)

        if (intent.hasExtra("sugardaddy")) {

            daddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy
            avatar.setImageResource(daddy.linkImage)
            textInfo.text = daddy.nickname + "\n" + DateFormat.getDateInstance().format(daddy.birthDate.time) + "\n" + daddy.getMoney()

        } else {

            baby = intent.getSerializableExtra("sugarbaby") as SugarBaby
            avatar.setImageResource(baby.linkImage)
            textInfo.text = baby.nickname + "\n" + DateFormat.getDateInstance().format(baby.birthDate.time) + "\n" + baby.caresAboutMoney()

        }

    }

    /**
     * Click event that calls the selected profile!
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun callSelectedUser(view: View) {

        if (ActivityCompat.checkSelfPermission(this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) { // Checks if the user has not granted permission for call phones

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, CALL_PHONE)) { // Checks if the app should ask permission for call phones

                ActivityCompat.requestPermissions(this, callPermission, callPermissionCode)

            } else { // Aks permission for call phones

                ActivityCompat.requestPermissions(this, callPermission, callPermissionCode)

            }

        } else { // Checks if the user has granted permission for call phones

            // TODO PREPARAR LA LLAMADA AL TELÉFONO DEL PERFIL SELECCIONADO

        }

    }

}
