package com.example.dreamdaddy.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import java.text.DateFormat

/**
 * The UserProfileActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After logging in or registering, an user can see his own profile.
 * @since December 2019
 */
class UserProfileActivity : AppCompatActivity() {

    private lateinit var daddy: SugarDaddy // If the user is a SugarDaddy
    private lateinit var baby: SugarBaby // If the user is a SugarBaby

    private val avatar by lazy { findViewById<ImageView>(R.id.imageViewProfileView) } // Avatar of the selected profile
    private val textNickname by lazy { findViewById<TextView>(R.id.textViewNickname) } // Nickname of the selected profile
    private val textEmail by lazy { findViewById<TextView>(R.id.textViewEmail) } // Email of the selected profile
    private val textBirthDate by lazy { findViewById<TextView>(R.id.textViewBirthDate) } // Birth date of the selected profile
    private val textMoney by lazy { findViewById<TextView>(R.id.textViewMoney) } // Money of the selected profile
    private val textKind by lazy { findViewById<TextView>(R.id.textViewKind) } // Kind Enum of the selected profile

    /**
     * Mandatory function invoked when creating the UserProfileActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since December 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_user_view)

        if (intent.hasExtra("sugardaddy")) { // Checks if the selected profile is a SugarDaddy

            daddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy
            avatar.setImageResource(daddy.linkImage)
            textNickname.text = daddy.nickname
            textBirthDate.text =  DateFormat.getDateInstance().format(daddy.birthDate.time)
            textMoney.text = daddy.getMoney().toString() + " €"
            textEmail.text = daddy.email
            textKind.text = daddy.kind.name

        } else { // The selected profile is a SugarBaby

            baby = intent.getSerializableExtra("sugarbaby") as SugarBaby
            avatar.setImageResource(baby.linkImage)
            textNickname.text = baby.nickname
            textBirthDate.text =  DateFormat.getDateInstance().format(baby.birthDate.time)
            textMoney.text = baby.caresAboutMoney().toString()
            textEmail.text = baby.email
            textKind.text = baby.kind.name

        }

    }

}