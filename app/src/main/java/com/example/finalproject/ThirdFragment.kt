package com.example.finalproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val workoutType = arguments?.getString("workoutType")
        val txt = view.findViewById<TextView>(R.id.workout_text)
        if (workoutType == "0") {
            txt.text = "Chest Workouts"
        } else if (workoutType == "1") {
            txt.text = "Back Workouts"
        }else if (workoutType == "2") {
            txt.text = "ABs Workouts"
        }else if (workoutType == "3") {
            txt.text = "Forearms Workouts"
        }else if (workoutType == "4") {
            txt.text = "Biceps Workouts"
        }else if (workoutType == "5") {
            txt.text = "Triceps Workouts"
        }else if (workoutType == "6") {
            txt.text = "Shoulders Workouts"
        }else if (workoutType == "7") {
            txt.text = "Legs Workouts"
        }else if (workoutType == "8") {
            txt.text = "Obliques Workouts"
        }

    }
}