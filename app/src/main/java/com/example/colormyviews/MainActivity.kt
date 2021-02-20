package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.colormyviews.databinding.ActivityMainBinding
import android.view.View as View

// added 19 Feb 2021
// see https://youtu.be/omml4lK_b-A    from 7.08 min  VIEW BINDING
// I could have used Data Binding instead but you have to edit the XML
// but with View binding setup is simpler and the use case is simpler

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  // the root layout of activity_main.xml
        // now all the views on the layout are accessible through the binding object
        binding.boxOneText.setBackgroundColor(Color.DKGRAY)
        binding.boxOneText.text = "Hello!!!"
        // test on Sat 20 Feb 2021

        //setListeners()
    }


    /**
     * Attaches listeners to all the views.
     */
    //private fun setListeners() {
    //val clickableViews: List<View> = listOf(box_one_text)

    /*
    for (item in clickableViews) {
        item.setOnClickListener { makeColored(it) }
    }
             */
    //}
}