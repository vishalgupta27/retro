package com.example.retroproject.activity


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.retroproject.R
import com.example.retroproject.adapter.Profilesdetailsadapter
import com.example.retroproject.adapter.UserInterestsAdapter
import com.example.retroproject.model.Data
import com.example.retroproject.model.UserInterests
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson


class profilesdetials2 : AppCompatActivity() {

    var gender: TextView? = null
    var name: TextView? = null
    var age: TextView? = null
    var complicated: TextView? = null
    private var location: TextView? = null
    var about: TextView? = null
    var viewpage1: ViewPager? = null
    var profilesdetailsadapter: Profilesdetailsadapter? = null
    var meet_profile_image: ArrayList<String> = ArrayList()

    private var adapters: UserInterestsAdapter? = null
    private var userinterests: ArrayList<UserInterests> = ArrayList()
    private var back: TextView? = null

    @SuppressLint("MissingInflatedId", "SetTextI18n", "UseCompatLoadingForDrawables",
        "NotifyDataSetChanged"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilesdetials2)

        gender = findViewById(R.id.tv_gender)
        name = findViewById(R.id.left_text_view)
        age = findViewById(R.id.right_text_view)
        complicated = findViewById(R.id.tv_complicated)
        location = findViewById(R.id.tv_loaction)
        viewpage1 = findViewById(R.id.viewpage1)
        about = findViewById(R.id.tv_aboutshow)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        back = findViewById(R.id.imgMenu)
        val recyclerview2 = findViewById<RecyclerView>(R.id.recyclerview2)



       // recyclerview2?.layoutManager = FlexboxLayoutManager(this)
        val staggeredGridLayoutManager = LinearLayoutManager(this)
        recyclerview2?.layoutManager = staggeredGridLayoutManager

        adapters = UserInterestsAdapter( userinterests,this)

        Log.d("arraylist", "onCreate:${userinterests.size} ")
        recyclerview2.adapter = adapters




        val gson = Gson()
        val itemobj = intent.getStringExtra("profile_data")
        if (itemobj != null) {
            val profile_data = gson.fromJson(itemobj, Data::class.java)

            gender!!.text = profile_data.gender
            complicated!!.text = profile_data.relationship_status
            location!!.text = profile_data.city
            about!!.text = profile_data.about_me
            name!!.text = profile_data.user_name + " , "
            age!!.text = profile_data.contact_no


            Log.d("dashboard_data", "onCreate:${profile_data.user_name}")
            for (i in 0 until profile_data.meet_profile_image.size) {
                Log.d("dashboard_data", "onCreate:${profile_data.meet_profile_image.get(i)}")
                meet_profile_image.add((profile_data.meet_profile_image.get(i)))
                Log.d("TAG", "images>>$meet_profile_image")
            }
             if (profile_data.user_interest !==null )
             {
                 userinterests.clear()
                 userinterests.addAll(profile_data.user_interest)
                 adapters!!.notifyDataSetChanged()
             }

            profilesdetailsadapter = Profilesdetailsadapter(this, meet_profile_image)
            Log.d("TAG", "images>>check")
            viewpage1?.adapter = profilesdetailsadapter
            adapters!!.notifyDataSetChanged()

            tabLayout.setupWithViewPager(viewpage1)

            back!!.setOnClickListener {
                val intent = Intent(this, chatpage::class.java)
                startActivity(intent)
            }

/*
            keys2?.setOnClickListener {
                keys2!!.setTextColor(Color.WHITE)
              //  keys2!!.setBackgroundColor(Color.BLUE)
              //  keys2!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                val roundedBackground = resources.getDrawable(R.drawable.corner_round2, null)
                keys2!!.background = roundedBackground
            }
            keys1?.setOnClickListener {
                keys1!!.setTextColor(Color.WHITE)
                val roundedBackground = resources.getDrawable(R.drawable.corner_round2, null)
                keys1!!.background = roundedBackground
            }*/
        }
    }
}
