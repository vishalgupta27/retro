package com.example.retroproject.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retroproject.R
import com.example.retroproject.model.UserInterests


class UserInterestsAdapter(
    private val mList: ArrayList<UserInterests>,
    private val context: Context
) : RecyclerView.Adapter<UserInterestsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main2, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        // sets the text to the textview from our itemHolder class
        holder.k1.text = ItemsViewModel.keyword
        holder.k2.text = ItemsViewModel.keyword
        holder.k3.text = ItemsViewModel.keyword
        holder.k4.text = ItemsViewModel.keyword

        holder.k1.setOnClickListener {

            holder.k1.setBackgroundColor(Color.BLUE)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val k1: TextView = itemView.findViewById(R.id.keyword_list1)
        val k2: TextView = itemView.findViewById(R.id.keyword_list2)
        val k3: TextView = itemView.findViewById(R.id.keyword_list3)
        val k4: TextView = itemView.findViewById(R.id.keyword_list4)

    }
}
