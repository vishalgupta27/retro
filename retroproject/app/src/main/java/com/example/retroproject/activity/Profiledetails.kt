package com.example.retroproject.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.retroproject.R
import com.example.retroproject.adapter.Profilesdetailsadapter
import com.example.retroproject.model.Data
import com.google.gson.Gson

class profiledetails : AppCompatActivity() {
    var nameTV: TextView? = null
    var contactTV: TextView? = null
    var emailTV: TextView? = null
    var dob_heading: TextView? = null
    var gender: TextView? = null
    var viewpage1: ViewPager? = null
    var circle_image: ImageView? = null
    var profilesdetailsadapter: Profilesdetailsadapter? = null
    var meet_profile_image: ArrayList<String> = ArrayList()

    private var back: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiledetails)

        nameTV = findViewById(R.id.nameTV)
        contactTV = findViewById(R.id.contactTV)
        emailTV = findViewById(R.id.emailTV)
        dob_heading = findViewById(R.id.dob_heading)
        gender = findViewById(R.id.gender)
        viewpage1 = findViewById(R.id.viewpage1)
        circle_image = findViewById(R.id.imageViewMain)

        back = findViewById(R.id.imgMenu)


        val gson = Gson()
        val itemobj = intent.getStringExtra("profile_data")
        if (itemobj != null) {
            val profile_data = gson.fromJson(itemobj, Data::class.java)
            nameTV!!.text = profile_data.user_name
            contactTV!!.text = profile_data.contact_no
            emailTV!!.text = profile_data.email
            dob_heading!!.text = profile_data.dob
            gender!!.text = profile_data.gender
            Log.d("dashboard_data", "onCreate:${profile_data.user_name}")
            for (i in 0 until profile_data.meet_profile_image.size) {
                Log.d("dashboard_data", "onCreate:${profile_data.meet_profile_image.get(i)}")
                meet_profile_image.addAll(listOf(profile_data.meet_profile_image.get(i)))
                Log.d("TAG", "images>>$meet_profile_image")
            }
        }

        profilesdetailsadapter = Profilesdetailsadapter(this, meet_profile_image)
        Log.d("TAG", "images>>check")
        viewpage1?.adapter = profilesdetailsadapter

        back!!.setOnClickListener {
            val intent = Intent(this, chatpage::class.java)
            startActivity(intent)
        }

    }
}