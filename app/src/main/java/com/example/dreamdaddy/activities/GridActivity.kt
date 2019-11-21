package com.example.dreamdaddy.activities

import android.os.Bundle
import android.widget.GridView
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
}