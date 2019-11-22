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

class GridActivity : AppCompatActivity() {

    private lateinit var gridAdapter: GridAdapter
    private lateinit var gridView: GridView

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

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.layout.layout_option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> {
            msgShow("Search")
            true
        }
        R.id.action_profile -> {
            msgShow("Profile")
            true
        }
        R.id.action_setting -> {
            msgShow("Setting")
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    fun msgShow(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}