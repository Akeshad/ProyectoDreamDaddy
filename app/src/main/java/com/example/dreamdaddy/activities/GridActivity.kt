package com.example.dreamdaddy.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarDaddy

/**
 * The GridActivity class extends from AppCompatActivity class as it's necessary in order to work.
 * After completing the form, the user will see a list of potential SugarBabies or SugarDaddies profiles.
 * Now he can tap on whichever profile he's curious to see!
 * @since November 2019
 */
class GridActivity : AppCompatActivity() {

    private lateinit var gridAdapter: GridAdapter // A custom Adapter for a GridView
    private lateinit var gridView: GridView // The GridView to include in this Activity

    /**
     * Mandatory function invoked when creating the GridActivity. Here's where the custom Adapter is linked to the GridView.
     * @param savedInstanceState If needed to import information from another Activity. Not needed in this case.
     * @since November 2019
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_grid_profiles)

        gridView = findViewById(R.id.gridLayoutGridProfiles)

        val daddies = ArrayList<SugarDaddy>()
        val daddy: SugarDaddy = intent.getSerializableExtra("sugardaddy") as SugarDaddy
        daddies.add(daddy)

        gridAdapter = GridAdapter(this, daddies)
        gridView.adapter = gridAdapter

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
     * Creates the Options Menu's Items in this Activity.
     * @param item The Menu Item to be displayed.
     * @since November 2019
     */
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_search -> {

            msgShow("Buscar")
            true

        }

        R.id.action_profile -> {

            msgShow("Perfil")
            true

        }

        R.id.action_setting -> {

            msgShow("Opciones")
            true

        }

        else -> { // If we got here, the user's action was not recognized. Invoke the superclass to handle it.

            super.onOptionsItemSelected(item)

        }

    }

    // TODO ESTO LUEGO TIENE QUE SER BORRADO
    fun msgShow(msg: String) {

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    }

}