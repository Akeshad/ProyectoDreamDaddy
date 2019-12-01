package com.example.dreamdaddy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import java.text.DateFormat

class SelectedProfileActivity : AppCompatActivity() {

    private lateinit var avatar: ImageView
    private lateinit var textInfo: TextView
    private lateinit var phoneButton: ImageButton
    private lateinit var daddy: SugarDaddy
    private lateinit var baby: SugarBaby

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_selected_profile)

        avatar = findViewById(R.id.imageViewSelectedProfile)
        textInfo = findViewById(R.id.textViewSelectedProfile)
        phoneButton = findViewById(R.id.imageButtonPhoneSelectedProfile)

        if (intent.hasExtra("sugardaddy")) {

            daddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy
            avatar.setImageResource(daddy.linkImage)
            textInfo.text = daddy.nickname + "\n" + DateFormat.getDateInstance().format(daddy.birthDate.time) + "\n" + daddy.getMoney()
        }else{

            baby = intent.getSerializableExtra("sugarbaby") as SugarBaby
            avatar.setImageResource(baby.linkImage)
            textInfo.text = baby.nickname + "\n" + DateFormat.getDateInstance().format(baby.birthDate.time) + "\n" + baby.caresAboutMoney()
        }

    }


}
