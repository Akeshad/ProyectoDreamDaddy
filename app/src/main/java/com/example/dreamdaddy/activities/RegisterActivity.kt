package com.example.dreamdaddy.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.layout_register.*
import java.text.DateFormat
import java.util.*
import kotlin.collections.HashMap

/**
 * The RegisterActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After choosing to be either a SugarDaddy or SugarBaby and his type/role, the user must fill this form in order to create his account and profile.
 * @since November 2019
 */
class RegisterActivity : AppCompatActivity() {

    private var calendarDate: Calendar = Calendar.getInstance() // Used for choosing a date from the Calendar. Related to the user's birth date.
    private val context = this // This Activity's Context
    private val auth = FirebaseAuth.getInstance() // Cloud Firestore's Authentication

    /**
     * Mandatory function invoked when creating the RegisterActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        editTextBirthDateRegister.setOnClickListener { // Lambda expression for setting the birth date via event.

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDayOfMonth ->

                editTextBirthDateRegister.setText("" + mDayOfMonth + "/" + mMonth + "/" + mYear)
                calendarDate.set(mYear, mMonth, mDayOfMonth)

            }, year, month, day)

            dpd.show()

        }

    }

    /**
     * Click event that retrieves a SugarDaddy or SugarBaby Object (depending on what the user chose before) and sets the form values into the Object.
     * This function also continues the App Cycle by going to the GridActivity.
     * @param view Predefined view parameter. Not needed in this case.
     * @since November 2019
     */
    fun subscribeNewUser(view: View) {

        val myFirebase = FirebaseFirestore.getInstance()

        if (intent.hasExtra("sugardaddy")) { // Checks if the user chose to be a SugarDaddy

            val sugarDaddy: SugarDaddy? = intent.getSerializableExtra("sugardaddy") as SugarDaddy

            if (sugarDaddy != null) { // Checks if the registering user is a SugarDaddy

                sugarDaddy.nickname = findViewById<EditText>(R.id.editTextUsernameRegister).text.toString()
                sugarDaddy.email = findViewById<EditText>(R.id.editTextEmailRegister).text.toString()
                sugarDaddy.password = findViewById<EditText>(R.id.editTextPasswordRegister).text.toString()
                sugarDaddy.birthDate = calendarDate

                val mapDaddy = HashMap<String, Any>()
                mapDaddy.put("birthDate", DateFormat.getDateInstance().format(sugarDaddy.birthDate.time).toString())
                mapDaddy.put("email", sugarDaddy.email)
                mapDaddy.put("kind", sugarDaddy.kind)
                mapDaddy.put("nickname", sugarDaddy.nickname)
                mapDaddy.put("password", sugarDaddy.password)
                mapDaddy.put("linkImage", sugarDaddy.linkImage)

                // Inserts the SugarDaddy into Cloud Firestore
                myFirebase.collection("dreamdaddy").add(mapDaddy).addOnSuccessListener { Toast.makeText(this, resources.getString(R.string.insertSuccess), Toast.LENGTH_LONG).show() }
                        .addOnFailureListener { Toast.makeText(this, resources.getString(R.string.insertFailure), Toast.LENGTH_LONG).show() }

                // Creates credentials for the user in Cloud Firestore
                auth.createUserWithEmailAndPassword(sugarDaddy.email, sugarDaddy.password).addOnCompleteListener {
                    if (it.isSuccessful) return@addOnCompleteListener }.addOnFailureListener { Toast.makeText(context, resources.getString(R.string.credentialsFailure), Toast.LENGTH_LONG).show() }

            }

            val intent = Intent(this, GridActivity::class.java)
            intent.putExtra("sugardaddy", sugarDaddy)
            startActivity(intent)

        } else { // If the user chose to be a SugarBaby

            val sugarBaby: SugarBaby? = intent.getSerializableExtra("sugarbaby") as SugarBaby

            if (sugarBaby != null) {

                sugarBaby.nickname = findViewById<EditText>(R.id.editTextUsernameRegister).text.toString()
                sugarBaby.email = findViewById<EditText>(R.id.editTextEmailRegister).text.toString()
                sugarBaby.password = findViewById<EditText>(R.id.editTextPasswordRegister).text.toString()
                sugarBaby.birthDate = calendarDate

                val mapBaby = HashMap<String, Any>()
                mapBaby.put("birthDate", DateFormat.getDateInstance().format(sugarBaby.birthDate.time).toString())
                mapBaby.put("email", sugarBaby.email)
                mapBaby.put("kind", sugarBaby.kind)
                mapBaby.put("nickname", sugarBaby.nickname)
                mapBaby.put("password", sugarBaby.password)
                mapBaby.put("linkImage", sugarBaby.linkImage)

                // Inserts the SugarDaddy into Cloud Firestore
                myFirebase.collection("dreamdaddy").add(mapBaby).addOnSuccessListener { Toast.makeText(this, resources.getString(R.string.insertSuccess), Toast.LENGTH_LONG).show() }
                        .addOnFailureListener { Toast.makeText(this, resources.getString(R.string.insertFailure), Toast.LENGTH_LONG).show() }

                // Creates credentials for the user in Cloud Firestore
                auth.createUserWithEmailAndPassword(sugarBaby.email, sugarBaby.password).addOnCompleteListener {
                    if (it.isSuccessful) return@addOnCompleteListener }.addOnFailureListener { Toast.makeText(context, resources.getString(R.string.credentialsFailure), Toast.LENGTH_LONG).show() }

                val intent = Intent(this, GridActivity::class.java)
                intent.putExtra("sugarbaby", sugarBaby)
                startActivity(intent)

            }

        }

    }

}
