/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding


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
        binding.boxOneText.setBackgroundColor(Color.LTGRAY)
        binding.boxOneText.text = "Hello!!!"
        // test on Sat 20 Feb 2021

        setListeners()
    }


    /**
     * Attaches listeners to all the views.
     */
    private fun setListeners() {
        val clickableViews: List<View> = listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText, binding.boxFourText, binding.boxFiveText, binding.constraintLayout, binding.redButton, binding.yellowButton, binding.greenButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }


    /**
     * Sets the background color of a view depending on it's resource id.
     * This is a way of using one click handler to do similar operations on a group of views.
     *
     * Demonstrates three different ways of setting colors.
     *     * Using a color constant from the Color class.
     *     * Using an Android color resource
     *     * Using a custom color defined in color.xml
     */
    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes are colored using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)


            // Boxes are colored using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Buttons are colored using Color class colors for background
            R.id.red_button -> view.setBackgroundColor(Color.RED)
            R.id.yellow_button -> view.setBackgroundColor(Color.YELLOW)
            R.id.green_button -> view.setBackgroundColor(Color.GREEN)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}