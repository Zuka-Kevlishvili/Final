package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

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
        val buttonProfile = view.findViewById<Button>(R.id.button_profile)


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
            findNavController().navigate(R.id.action_homeFragment_to_editProfileFragment)
        }
    }
}