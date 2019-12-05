package com.example.dreamdaddy.activities

import android.app.Activity
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
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
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

        // Lambda expression for setting the birth date via event.
        editTextBirthDateRegister.setOnClickListener {

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

            if (sugarDaddy != null) {

                sugarDaddy.nickname = findViewById<EditText>(R.id.editTextUsernameRegister).text.toString()
                sugarDaddy.email = findViewById<EditText>(R.id.editTextEmailRegister).text.toString()
                sugarDaddy.password = findViewById<EditText>(R.id.editTextPasswordRegister).text.toString()
                sugarDaddy.birthDate = calendarDate



                //-------------------------------------------DATABASE Inserts----------------------------

                val mapDaddy = HashMap<String, Any>()
                mapDaddy.put("birthDate", DateFormat.getDateInstance().format(sugarDaddy.birthDate.time).toString())
                mapDaddy.put("email", sugarDaddy.email)
                mapDaddy.put("kind", sugarDaddy.kind)
                mapDaddy.put("nickname", sugarDaddy.nickname)
                mapDaddy.put("password", sugarDaddy.password)
                mapDaddy.put("linkImage", sugarDaddy.linkImage)
                mapDaddy.put("telephone", 0) // TODO ESTE SE TENDRA QUE BORRAR, ESTA DE PRUEBAS

                myFirebase.collection("dreamdaddy").add(mapDaddy).addOnSuccessListener { Toast.makeText(this, resources.getString(R.string.insertSuccess), Toast.LENGTH_LONG).show() }
                        .addOnFailureListener { Toast.makeText(this, resources.getString(R.string.insertFailure), Toast.LENGTH_LONG).show() }

                //-------------------------------------------DATABASE Register User----------------------------

                val estaActividad = this

                val auth = FirebaseAuth.getInstance()
                //Al usarla dentro de task, la variable t ha de ser declarada final
                val t = auth.createUserWithEmailAndPassword(sugarDaddy.email, sugarDaddy.password)
                t.addOnCompleteListener(this, object : OnCompleteListener<AuthResult> {
                    override fun onComplete(p0: Task<AuthResult>) {
                        if (t.isSuccessful) {
                            Toast.makeText(estaActividad, "Completado con éxito", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(estaActividad, "Todo mal", Toast.LENGTH_LONG).show()
                        }
                    }
                })

                //---------------INTENT--------------------------------

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



                    //-------------------------------------------DATABASE-------------------------------

                    val mapBaby = HashMap<String, Any>()
                    mapBaby.put("birthDate", DateFormat.getDateInstance().format(sugarBaby.birthDate.time).toString())
                    mapBaby.put("email", sugarBaby.email)
                    mapBaby.put("kind", sugarBaby.kind)
                    mapBaby.put("nickname", sugarBaby.nickname)
                    mapBaby.put("password", sugarBaby.password)
                    mapBaby.put("linkImage", sugarBaby.linkImage)

                    myFirebase.collection("dreamdaddy").add(mapBaby).addOnSuccessListener { Toast.makeText(this, resources.getString(R.string.insertSuccess), Toast.LENGTH_LONG).show() }
                            .addOnFailureListener { Toast.makeText(this, resources.getString(R.string.insertFailure), Toast.LENGTH_LONG).show() }

                    //-------------------------------------------DATABASE Register User----------------------------

                    val estaActividad = this

                    val auth = FirebaseAuth.getInstance()
                    //Al usarla dentro de task, la variable t ha de ser declarada final
                    val t = auth.createUserWithEmailAndPassword(sugarBaby.email, sugarBaby.password)
                    t.addOnCompleteListener(this, object : OnCompleteListener<AuthResult> {
                        override fun onComplete(p0: Task<AuthResult>) {
                            if (t.isSuccessful) {
                                Toast.makeText(estaActividad, "Completado con éxito", Toast.LENGTH_LONG).show()
                            }else{
                                Toast.makeText(estaActividad, "Todo mal", Toast.LENGTH_LONG).show()
                            }
                        }
                    })

                    //-------------------INTENT--------------------------------

                    val intent = Intent(this, GridActivity::class.java)
                    intent.putExtra("sugarbaby", sugarBaby)
                    startActivity(intent)
                }

            }

        }

    }
}