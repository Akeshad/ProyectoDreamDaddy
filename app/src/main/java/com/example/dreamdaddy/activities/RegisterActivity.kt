package com.example.dreamdaddy.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import kotlinx.android.synthetic.main.layout_register.*
import java.sql.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var dateStr: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        editTextBirthDateRegister.setOnClickListener{
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDayOfMonth ->
                editTextBirthDateRegister.setText("" + mDayOfMonth + "/" + mMonth + "/" + mYear)
                dateStr = ("" + mDayOfMonth + "/" + mMonth + "/" + mYear).toString()
            }, year, month , day )

            dpd.show()
        }
    }

    fun subscribeNewUser(view: View) {
        var sugarDaddy : SugarDaddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy
        if(sugarDaddy != null) {
            sugarDaddy.nickname = findViewById<EditText>(R.id.editTextUsernameRegister).text.toString()
            sugarDaddy.email = findViewById<EditText>(R.id.editTextEmailRegister).text.toString()
            sugarDaddy.password = findViewById<EditText>(R.id.editTextPasswordRegister).text.toString()
            sugarDaddy.birthDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            val intent = Intent(this, GridActivity::class.java)
            intent.putExtra("sugardaddy", sugarDaddy)
            startActivity(intent)
        }

     /*  if(sugarBaby != null){
            sugarBaby.nickname = findViewById<EditText>(R.id.editTextUsernameRegister).text.toString()
            sugarBaby.email = findViewById<EditText>(R.id.editTextEmailRegister).text.toString()
            sugarBaby.password = findViewById<EditText>(R.id.editTextPasswordRegister).text.toString()
            sugarBaby.birthDate = findViewById<EditText>(R.id.editTextBirthDateRegister).text as Date
        }*/
    }


}