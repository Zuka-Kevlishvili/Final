package com.example.finalproject.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttonWorkouts = view.findViewById<ImageButton>(R.id.button_workouts)
        val buttonNutrition = view.findViewById<ImageButton>(R.id.button_nutrition)
        val buttonProfile = view.findViewById<ImageButton>(R.id.button_profile)


        buttonWorkouts.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("contentType", "workouts")
            findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
        }

        buttonNutrition.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("contentType", "nutrition")
            findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
        }

        buttonProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        buttonProfile.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // change the button's background color or image
                    v.animate().scaleX(1.1f).scaleY(1.1f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP -> {
                    // change the button's background color or image back to normal
                    v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                    v.performClick()
                }
            }
            true
        }
    }
}