package com.example.dreamdaddy.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.KindBaby
import com.example.dreamdaddy.classes.KindDaddy
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * The GridActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After completing the form, the user will see a list of potential SugarBabies or SugarDaddies profiles.
 * Now he can tap on whichever profile he's curious to see!
 * @since November 2019
 */
class GridActivity : AppCompatActivity() {

    private lateinit var gridAdapterDaddy: GridAdapterDaddy // A custom daddies' Adapter for a GridView
    private lateinit var gridView: GridView // The GridView to include in this Activity
    private lateinit var gridAdapterBaby: GridAdapterBaby // A custom babies' Adapter for a GridView
    private lateinit var intentDaddy: SugarDaddy // Registered SugarDaddy
    private lateinit var intentBaby: SugarBaby // Registered SugarBaby

    private val context = this // This Activity's context

    /**
     * Mandatory function invoked when creating the GridActivity. Here's where the custom Adapter is linked to the GridView.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_grid_profiles)

        val myFirebase = FirebaseDatabase.getInstance().reference

        gridView = findViewById(R.id.gridLayoutGridProfiles)

        if (intent.hasExtra("sugardaddy")) { // Checks if the intent contents a SugarDaddy

            intentDaddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy

            val babies = ArrayList<SugarBaby>()

            val baby1 = SugarBaby() // First SugarBaby sample
            baby1.nickname = "Abel"
            baby1.kind = KindBaby.SPOILED
            baby1.linkImage = R.drawable.baby_spoiled
            val sdf1 = SimpleDateFormat("MM-dd-yyyy")
            val date1: Date? = sdf1.parse("3-24-1993")
            val cal1 = sdf1.calendar
            baby1.birthDate = cal1
            baby1.telephone = "123456789"
            babies.add(baby1)

            val baby2 = SugarBaby() // Second SugarBaby sample
            baby2.nickname = "Álvaro"
            baby2.kind = KindBaby.FANCY
            baby2.linkImage = R.drawable.baby_fancy
            val sdf2 = SimpleDateFormat("MM-dd-yyyy")
            val date2: Date? = sdf2.parse("11-10-1993")
            val cal2 = sdf2.calendar
            baby2.birthDate = cal2
            baby2.telephone = "987654321"
            babies.add(baby2)

            val baby3 = SugarBaby() // Third SugarBaby sample
            baby3.nickname = "Migui"
            baby3.kind = KindBaby.ROMANTIC
            baby3.linkImage = R.drawable.baby_romantic
            val sdf3 = SimpleDateFormat("MM-dd-yyyy")
            val date3: Date? = sdf3.parse("2-14-1994")
            val cal3 = sdf3.calendar
            baby3.birthDate = cal3
            baby3.telephone = "987123456"
            babies.add(baby3)

            val baby4 = SugarBaby() // Fourth SugarBaby sample
            baby4.nickname = "Paquiqui"
            baby4.kind = KindBaby.EMO
            baby4.linkImage = R.drawable.baby_emo
            val sdf4 = SimpleDateFormat("MM-dd-yyyy")
            val date4: Date? = sdf4.parse("6-21-1991")
            val cal4 = sdf4.calendar
            baby4.birthDate = cal4
            baby4.telephone = "918273645"
            babies.add(baby4)

            val baby5 = SugarBaby() // Fifth SugarBaby sample
            baby5.nickname = "Arthas"
            baby5.kind = KindBaby.SPOILED
            baby5.linkImage = R.drawable.baby_spoiled
            val sdf5 = SimpleDateFormat("MM-dd-yyyy")
            val date5: Date? = sdf5.parse("12-30-1990")
            val cal5 = sdf5.calendar
            baby5.birthDate = cal5
            baby5.telephone = "123498765"
            babies.add(baby5)

            val baby6 = SugarBaby() // Sixth SugarBaby sample
            baby6.nickname = "Jesse"
            baby6.kind = KindBaby.OTTER
            baby6.linkImage = R.drawable.baby_otter
            val sdf6 = SimpleDateFormat("MM-dd-yyyy")
            val date6: Date? = sdf6.parse("11-13-1994")
            val cal6 = sdf6.calendar
            baby6.birthDate = cal6
            baby6.telephone = "555555666"
            babies.add(baby6)

            gridAdapterBaby = GridAdapterBaby(this, babies)
            gridView.adapter = gridAdapterBaby


        } else { // Checks if the intent contents a SugarBaby

            intentBaby = intent.getSerializableExtra("sugarbaby") as SugarBaby

            val daddies = ArrayList<SugarDaddy>()
            val daddy1 = SugarDaddy() // First SugarDaddy sample
            daddy1.nickname = "Antonio"
            daddy1.kind = KindDaddy.BADDY
            daddy1.linkImage = R.drawable.daddy_baddy
            val sdf1 = SimpleDateFormat("MM-dd-yyyy")
            val date1: Date? = sdf1.parse("12-10-1993")
            val cal1 = sdf1.calendar
            daddy1.birthDate = cal1
            daddy1.setMoney(543670)
            daddy1.telephone = "123456789"
            daddies.add(daddy1)

            val daddy2 = SugarDaddy() // Second SugarDaddy sample
            daddy2.nickname = "Ramón"
            daddy2.kind = KindDaddy.BEAR
            daddy2.linkImage = R.drawable.daddy_bear
            val sdf2 = SimpleDateFormat("MM-dd-yyyy")
            val date2: Date? = sdf2.parse("12-10-1993")
            val cal2: Calendar = sdf2.calendar
            daddy2.birthDate = cal2
            daddy2.setMoney(68402)
            daddy2.telephone = "987654321"
            daddies.add(daddy2)

            val daddy3 = SugarDaddy() // Third SugarDaddy sample
            daddy3.nickname = "Alejandro"
            daddy3.kind = KindDaddy.GOTHIC
            daddy3.linkImage = R.drawable.daddy_gothic
            val sdf3 = SimpleDateFormat("MM-dd-yyyy")
            val date3: Date? = sdf3.parse("12-10-1993")
            val cal3: Calendar = sdf3.calendar
            daddy3.birthDate = cal3
            daddy3.setMoney(35634)
            daddy3.telephone = "123789456"
            daddies.add(daddy3)

            val daddy4 = SugarDaddy() // Fourth SugarDaddy sample
            daddy4.nickname = "Lucas"
            daddy4.kind = KindDaddy.INTELLECTUAL
            daddy4.linkImage = R.drawable.daddy_intellectual
            val sdf4 = SimpleDateFormat("MM-dd-yyyy")
            val date4: Date? = sdf4.parse("12-10-1993")
            val cal4: Calendar = sdf4.calendar
            daddy4.birthDate = cal4
            daddy4.setMoney(40587)
            daddy4.telephone = "987321654"
            daddies.add(daddy4)

            val daddy5 = SugarDaddy() // Fifth SugarDaddy sample
            daddy5.nickname = "Jordi"
            daddy5.kind = KindDaddy.SPORTY
            daddy5.linkImage = R.drawable.daddy_sporty
            val sdf5 = SimpleDateFormat("MM-dd-yyyy")
            val date5: Date? = sdf5.parse("12-10-1993")
            val cal5: Calendar = sdf5.calendar
            daddy5.birthDate = cal5
            daddy5.setMoney(123455)
            daddy5.telephone = "918273645"
            daddies.add(daddy5)

            val daddy6 = SugarDaddy() // Sixth SugarDaddy sample
            daddy6.nickname = "Martín"
            daddy6.kind = KindDaddy.SOPHISTICATED
            daddy6.linkImage = R.drawable.daddy_sophisticated
            val sdf6 = SimpleDateFormat("MM-dd-yyyy")
            val date6: Date? = sdf6.parse("12-10-1993")
            val cal6: Calendar = sdf6.calendar
            daddy6.birthDate = cal6
            daddy6.setMoney(82312)
            daddy6.telephone = "675493012"
            daddies.add(daddy6)

            /*
            myFirebase.child("dreamdaddy").addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()) {

                        for (ds in snapshot.getChildren()) {

                            val nickname = ds.child("nickname").value.toString()
                            val linkImage = ds.child("linkImage").value.toString()
                            val birthDate = ds.child("birthDate").value.toString()
                            val telephone = ds.child("telephone").value.toString()

                            val daddy = SugarDaddy()
                            daddy.nickname = nickname
                            daddy.linkImage = Integer.parseInt(linkImage)

                            val sdf = SimpleDateFormat("MM dd yyyy")

                            val date: Date? = sdf.parse(birthDate)
                            val cal: Calendar = sdf.calendar

                            daddy.birthDate = cal
                            daddy.telephone = telephone

                            daddies.add(daddy)

                        }

                        gridAdapterDaddy = GridAdapterDaddy(context, daddies)
                        gridView.adapter = gridAdapterDaddy

                    }

                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
            */

            gridAdapterDaddy = GridAdapterDaddy(context, daddies)
            gridView.adapter = gridAdapterDaddy

        }

    }

    /**
     * Creates an Options Menu in this Activity which must be inflated.
     * @param menu The menu to be displayed.
     * @since November 2019
     */
    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.layout.layout_option_menu, menu)

        return true

    }

    /**
     * Creates the Options Menu's Items in this Activity and allows to continue the App Cycle by going to other activities.
     * These activities are UserProfileActivity and UserSettingActivity.
     * @param item The Menu Item to be displayed.
     * @since November 2019
     */
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_profile -> { // When the user clicks on Perfil

            val intentActivity = Intent(context, UserProfileActivity::class.java)

            if (intent.hasExtra("sugardaddy")) { // Checks if in this Activity the user registered as a SugarDaddy

                intentActivity.putExtra("sugardaddy", intentDaddy)

            } else { // Checks if in this Activity the user registered as a SugarBaby

                intentActivity.putExtra("sugarbaby", intentBaby)

            }

            startActivity(intentActivity)
            true

        }

        R.id.action_setting -> { // When the user clicks on Ajustes

            val intentActivity = Intent(context, UserSettingActivity::class.java)

            if (intent.hasExtra("sugardaddy")) { // Checks if in this Activity the user registered as a SugarDaddy

                intentActivity.putExtra("sugardaddy", intentDaddy)

            } else { // Checks if in this Activity the user registered as a SugarBaby

                intentActivity.putExtra("sugarbaby", intentBaby)

            }

            startActivity(intentActivity)
            true

        }

        else -> { // If we got here, the user's action was not recognized. Invoke the superclass to handle it.

            super.onOptionsItemSelected(item)

        }

    }

}