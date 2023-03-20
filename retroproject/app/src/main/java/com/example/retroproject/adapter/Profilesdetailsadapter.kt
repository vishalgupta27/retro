package com.example.retroproject.adapter

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.retroproject.R


class Profilesdetailsadapter(context: Context, meet_profile_image: ArrayList<String>) : PagerAdapter() {
    var context: Context
    private lateinit var meet_profile_image: ArrayList<String>

    // Layout Inflater
    private var inflater: LayoutInflater? = null

    // Viewpager Constructor
    init {
        this.context = context
        this.meet_profile_image = meet_profile_image
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        Log.d(TAG, "getCount:${meet_profile_image.size} ")
        return meet_profile_image.size

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //for profilesdetails code
//        val view: View = inflater!!.inflate(R.layout.imagesl, container, false)
//        val imageView = view.findViewById<View>(R.id.imageViewMain) as ImageView
        val view: View = inflater!!.inflate(R.layout.viewprofilesdetails2, container, false)
        val imageView = view.findViewById<View>(R.id.rl_images) as ImageView
        Log.d("TAG", "instantiateItem:this is ")
        Glide.with(context)
            .load(meet_profile_image[position])
            .into(imageView)


        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        if (`object` is ImageView) {
            (container as ViewPager).removeView(`object`)
        } else if (`object` is CardView) {
            (container as ViewPager).removeView(`object`)
        }
    }


}
