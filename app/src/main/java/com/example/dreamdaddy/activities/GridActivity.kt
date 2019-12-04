package com.example.dreamdaddy.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy
import com.google.firebase.database.*
import java.text.DateFormat
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

    private val context = this

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

            val daddies = ArrayList<SugarDaddy>()
            // val daddy: SugarDaddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy
            // daddies.add(daddy)

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

                           val sdf : SimpleDateFormat =  SimpleDateFormat("MM dd yyyy")

                            val date : Date =  sdf.parse(birthDate)
                            val cal : Calendar = sdf.calendar

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



        } else { // Checks if the intent contents a SugarBaby

            val babies = ArrayList<SugarBaby>()
            val baby: SugarBaby = intent.getSerializableExtra("sugarbaby") as SugarBaby
            babies.add(baby)

            gridAdapterBaby = GridAdapterBaby(this, babies)
            gridView.adapter = gridAdapterBaby

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
     * These activities are UserProfileActivity and Settings.
     * @param item The Menu Item to be displayed.
     * @since November 2019
     */
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_profile -> {

            val intent = Intent(this, UserProfileActivity::class.java)
            this.startActivity(intent)
            true

        }

        R.id.action_setting -> {

            true

        }

        else -> { // If we got here, the user's action was not recognized. Invoke the superclass to handle it.

            super.onOptionsItemSelected(item)

        }

    }

}