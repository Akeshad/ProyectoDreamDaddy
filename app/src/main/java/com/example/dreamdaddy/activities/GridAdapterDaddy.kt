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

/**
 * The GridAdapterDaddy class extends from BaseAdapter class as it's necessary in order to work.
 * It helps displaying the GridView in the GridActivity.
 * @constructor It requires two parameters: a Context and a ArrayList<SugarDaddy>.
 * @param context The Activity's Context where the constructor will be invoked.
 * @param daddies The ArrayList which will hold the SugarDaddies displayed in the GridActivity's GridView.
 * @since November 2019
 */
class GridAdapterDaddy (private var context: Context, private var daddies: ArrayList<SugarDaddy>) : BaseAdapter() {

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to indicate the size to be displayed in the GridActivity's GridView.
     * @since November 2019
     */
    override fun getCount(): Int {

        return daddies.size

    }

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to select a position from the ArrayList<SugarDaddy> in the GridActivity's GridView.
     * @param position The index from the ArrayList<SugarDaddy>.
     * @since November 2019
     */
    override fun getItem(position: Int): Any {

        return daddies[position]

    }

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to select the ID of the position from the ArrayList<SugarDaddy> in the GridActivity's GridView.
     * @param position The index from the ArrayList<SugarDaddy>.
     * @since November 2019
     */
    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    /**
     * Mandatory implemented function invoked when implementing from BaseAdapter.
     * It's necessary in order to select a position from the ArrayList<SugarDaddy> in the GridActivity's GridView.
     * This function also allows the button to invoke the event for going to the SelectedProfileActivity in the App Cycle.
     * @param position The index from the ArrayList<SugarDaddy>.
     * @param convertView The view to be displayed in the GridActivity's GridView.
     * @param parent The ViewGroup in the GridActivity.
     * @since November 2019
     */
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