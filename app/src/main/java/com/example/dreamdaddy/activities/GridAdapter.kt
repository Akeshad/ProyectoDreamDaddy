package com.example.dreamdaddy.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarDaddy

class GridAdapter(private var context: Context, private var daddies: ArrayList<SugarDaddy>) : BaseAdapter() {

    override fun getCount(): Int {
        return daddies.size
    }

    override fun getItem(position: Int): Any {
        return daddies[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_grid_profile, parent, false)
        }

        val daddy = getItem(position) as SugarDaddy

        val imageButton = view!!.findViewById<ImageButton>(R.id.imageButtonGrid)
        imageButton.setImageResource(daddy.linkImage)

        imageButton.setOnClickListener {
            val nextActivity = Intent(context, SelectedProfileActivity::class.java)
            nextActivity.putExtra("sugardaddy", daddy)
            context.startActivity(nextActivity)
        }

        return view
    }

}