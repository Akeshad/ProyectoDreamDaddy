package com.example.dreamdaddy.activities

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.example.dreamdaddy.R
import com.example.dreamdaddy.classes.SugarBaby

/**
 * The GridAdapterBaby class extends from BaseAdapter class as it's necessary in order to work.
 * It helps displaying the GridView in the GridActivity.
 * @constructor It requires two parameters: a Context and a ArrayList<SugarBaby>.
 * @param context The Activity's Context where the constructor will be invoked.
 * @param babies The ArrayList which will hold the SugarBabies displayed in the GridActivity's GridView.
 * @since November 2019
 */
class GridAdapterBaby (private var context: Context, private var babies: ArrayList<SugarBaby>) : BaseAdapter() {

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to indicate the size to be displayed in the GridActivity's GridView.
     * @since November 2019
     */
    override fun getCount(): Int {

        return babies.size

    }

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to select a position from the ArrayList<SugarBaby> in the GridActivity's GridView.
     * @param position The index from the ArrayList<SugarDaddy>.
     * @since November 2019
     */
    override fun getItem(position: Int): Any {

        return babies[position]

    }

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to select the ID of the position from the ArrayList<SugarBaby> in the GridActivity's GridView.
     * @param position The index from the ArrayList<SugarBaby>.
     * @since November 2019
     */
    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to select a position from the ArrayList<SugarBaby> in the GridActivity's GridView.
     * This function also allows the button to invoke the event for going to the SelectedProfileActivity in the App Cycle.
     * @param position The index from the ArrayList<SugarBaby>.
     * @param convertView The view to be displayed in the GridActivity's GridView.
     * @param parent The ViewGroup in the GridActivity.
     * @since November 2019
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.adapter_grid_profile, parent, false)

        }

        val baby = getItem(position) as SugarBaby
        val imageButton = view!!.findViewById<ImageButton>(R.id.imageButtonGrid)
        val textBaby = view.findViewById<TextView>(R.id.textViewProfileGrid)
        imageButton.setImageResource(baby.linkImage)
        textBaby.text = baby.nickname

        imageButton.setOnClickListener {

            val nextActivity = Intent(context, SelectedProfileActivity::class.java)
            nextActivity.putExtra("sugarbaby", baby)
            context.startActivity(nextActivity)

        }

        return view

    }

}