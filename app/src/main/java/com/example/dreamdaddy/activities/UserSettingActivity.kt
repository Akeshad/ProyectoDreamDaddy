package com.example.dreamdaddy.activities

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy

/**
 * The UserSettingActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After logging in or registering, an user can change different options regarding his own profile.
 * @since November 2019
 */
class UserSettingActivity : AppCompatActivity() {

    private val selectOperation by lazy { findViewById<Spinner>(R.id.user_options) } // The Activity's spinner
    private val inputTelephone by lazy { findViewById<EditText>(R.id.editUserProfileOptionMenuTelephone) } // The Activity's EditText for Telephone
    private val inputNickname by lazy { findViewById<EditText>(R.id.editUserProfileOptionMenuNickname) } // The Activity's EditText for Nickname
    private val inputMoney by lazy { findViewById<EditText>(R.id.editUserProfileOptionMenuMoney) } // The Activity's EditText for Money
    private val inputPassword by lazy { findViewById<EditText>(R.id.editUserProfileOptionMenuPassword) } // The Activity's EditText for Password

    private val context = this // This Activity's context

    /**
     * Mandatory function invoked when creating the UserSettingActivity.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_user_profile)

        if (intent.hasExtra("sugardaddy")) { // Checks if the user is a SugarDaddy

            val operations = arrayOf("Teléfono", "Nickname", "Sueldo anual", "Contraseña")
            val adapter = ArrayAdapter<String>(this, R.layout.elemts_spinner_user_options, operations)

            selectOperation.adapter = adapter

            selectOperation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(p0: AdapterView<*>?) {}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    when (selectOperation.selectedItem.toString()) { // SugarDaddy Spinner's switch options

                        "Teléfono" -> {

                            inputTelephone.visibility = EditText.VISIBLE
                            inputNickname.visibility = EditText.GONE
                            inputMoney.visibility = EditText.GONE
                            inputPassword.visibility = EditText.GONE

                        }

                        "Nickname" -> {

                            inputTelephone.visibility = EditText.GONE
                            inputNickname.visibility = EditText.VISIBLE
                            inputMoney.visibility = EditText.GONE
                            inputPassword.visibility = EditText.GONE

                        }

                        "Sueldo anual" -> {

                            inputTelephone.visibility = EditText.GONE
                            inputNickname.visibility = EditText.GONE
                            inputMoney.visibility = EditText.VISIBLE
                            inputPassword.visibility = EditText.GONE

                        }

                        "Contraseña" -> {

                            inputTelephone.visibility = EditText.GONE
                            inputNickname.visibility = EditText.GONE
                            inputMoney.visibility = EditText.GONE
                            inputPassword.visibility = EditText.VISIBLE

                        }

                    }

                }

            }

        } else { // Checks if the user is a SugarBaby

            val operations = arrayOf("Teléfono", "Nickname", "Contraseña")
            val adapter = ArrayAdapter<String>(this, R.layout.elemts_spinner_user_options, operations)

            selectOperation.adapter = adapter

            selectOperation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(p0: AdapterView<*>?) {}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    when (selectOperation.selectedItem.toString()) { // SugarBaby Spinner's switch options

                        "Teléfono" -> {

                            inputTelephone.visibility = EditText.VISIBLE
                            inputNickname.visibility = EditText.GONE
                            inputMoney.visibility = EditText.GONE
                            inputPassword.visibility = EditText.GONE

                        }

                        "Nickname" -> {

                            inputTelephone.visibility = EditText.GONE
                            inputNickname.visibility = EditText.VISIBLE
                            inputMoney.visibility = EditText.GONE
                            inputPassword.visibility = EditText.GONE

                        }

                        "Contraseña" -> {

                            inputTelephone.visibility = EditText.GONE
                            inputNickname.visibility = EditText.GONE
                            inputMoney.visibility = EditText.GONE
                            inputPassword.visibility = EditText.VISIBLE

                        }

                    }

                }

            }

        }

    }

    /**
     * Event function invoked when pressing the Activity's button. The main goal is to select which option the user wants to modify.
     * Then, he writes the information in the EditText and, afterwards, he only must press said button to save the changes.
     * @param view If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    fun saveChanges(view: View) {

        if (intent.hasExtra("sugardaddy")) { // Checks if the user is a SugarDaddy

            val daddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy

            when (this.selectOperation.selectedItem.toString()) { // SugarDaddy Spinner's switch options

                "Teléfono" -> {

                    if (inputTelephone.text.isNotEmpty()) {

                        daddy.telephone = inputTelephone.text.toString()

                    } else {

                        Toast.makeText(context, resources.getString(R.string.emptyInput), Toast.LENGTH_LONG).show()

                    }

                }

                "Nickname" -> {

                    if (inputNickname.text.isNotEmpty()) {

                        daddy.nickname = inputTelephone.text.toString()

                    } else {

                        Toast.makeText(context, resources.getString(R.string.emptyInput), Toast.LENGTH_LONG).show()

                    }

                }

                "Sueldo anual" -> {

                    if (inputMoney.text.isNotEmpty()) {

                        daddy.setMoney(Integer.parseInt(inputTelephone.text.toString()))

                    } else {

                        Toast.makeText(context, resources.getString(R.string.emptyInput), Toast.LENGTH_LONG).show()

                    }

                }

                "Contraseña" -> {

                    if (inputPassword.text.isNotEmpty()) {

                        daddy.password = inputTelephone.text.toString()

                    } else {

                        Toast.makeText(context, resources.getString(R.string.emptyInput), Toast.LENGTH_LONG).show()

                    }

                }

            }

        } else { // Checks if the user is a SugarBaby

            val baby = intent.getSerializableExtra("sugarbaby") as SugarBaby

            when (this.selectOperation.selectedItem.toString()) { // SugarBaby Spinner's switch options

                "Teléfono" -> {

                    if (inputTelephone.text.isNotEmpty()) {

                        baby.telephone = inputTelephone.text.toString()

                    } else {

                        Toast.makeText(context, resources.getString(R.string.emptyInput), Toast.LENGTH_LONG).show()

                    }

                }

                "Nickname" -> {

                    if (inputNickname.text.isNotEmpty()) {

                        baby.nickname = inputTelephone.text.toString()

                    } else {

                        Toast.makeText(context, resources.getString(R.string.emptyInput), Toast.LENGTH_LONG).show()

                    }

                }

                "Contraseña" -> {

                    if (inputPassword.text.isNotEmpty()) {

                        baby.password = inputTelephone.text.toString()

                    } else {

                        Toast.makeText(context, resources.getString(R.string.emptyInput), Toast.LENGTH_LONG).show()

                    }

                }

            }

        }

    }

}