package com.example.retroproject.activity


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retroproject.R


class MainActivity2 : AppCompatActivity() {
    private var mKeywordList: LinearLayout? = null
    private var mKeywordViews: MutableList<TextView>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mKeywordList = findViewById(R.id.keyword_list)
        mKeywordViews = ArrayList()

        // Add some example keywords
        addKeyword("android")
        addKeyword("java")
        addKeyword("kotlin")
        addKeyword("xml")

        // Select the first keyword by default
        selectKeyword((mKeywordViews as ArrayList<TextView>).get(0))
    }

    private fun addKeyword(keyword: String) {
        // Create a new TextView for the keyword
        val keywordView = TextView(this)
        keywordView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        keywordView.setPadding(16, 16, 16, 16)
        keywordView.textSize = 16f
        keywordView.text = keyword
        keywordView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // Deselect the currently selected keyword (if any)
                for (view in mKeywordViews!!) {
                    view.setBackgroundColor(Color.TRANSPARENT)
                }
                // Select the clicked keyword
                selectKeyword(keywordView)
            }
        })
        // Add the keyword view to the list and the layout
        mKeywordViews!!.add(keywordView)
        mKeywordList!!.addView(keywordView)
    }

    private fun selectKeyword(keywordView: TextView) {
        // Change the background color of the selected keyword
        keywordView.setBackgroundColor(Color.BLUE)
    }
}
