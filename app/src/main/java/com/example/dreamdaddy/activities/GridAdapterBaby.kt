package com.example.dreamdaddy.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby
import com.example.dreamdaddy.classes.SugarDaddy

class GridAdapterBaby (private var context: Context, private var babies: ArrayList<SugarBaby>) : BaseAdapter() {

    override fun getCount(): Int {
        return babies.size
    }

    override fun getItem(position: Int): Any {
        return babies[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_grid_profile, parent, false)
        }

        val baby = getItem(position) as SugarBaby

        val imageButton = view!!.findViewById<ImageButton>(R.id.imageButtonGrid)
        imageButton.setImageResource(baby.linkImage)

        imageButton.setOnClickListener {
            val nextActivity = Intent(context, SelectedProfileActivity::class.java)
            nextActivity.putExtra("sugarbaby", baby)
            context.startActivity(nextActivity)
        }

        return view
    }
}