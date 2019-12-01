package com.example.dreamdaddy.activities


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R

class UserProfile : AppCompatActivity() {

    val selectOperation by lazy{
        findViewById<Spinner>(R.id.user_options)}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_user_profile)

        val operations= arrayOf("Teléfono","Nickname","Sueldo anual","Contraseña")
        var adapter= ArrayAdapter<String>(
                this,R.layout.elemts_spinner_user_options,
                operations)

        selectOperation.adapter=adapter

    }

    fun SaveChanges(view: View) {
        when(this.selectOperation.selectedItem.toString()){
            "Teléfono"->{

            }
            "Nickname"->{


            }
            "Sueldo anua"->{


            }
            "Contraseña"->{


            }
        }
    }


}