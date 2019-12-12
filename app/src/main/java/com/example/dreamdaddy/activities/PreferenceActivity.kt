package com.example.dreamdaddy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dreamdaddy.R
import android.preference.PreferenceActivity
class PreferenceActivity :PreferenceActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preference_screen)

    }
    }

