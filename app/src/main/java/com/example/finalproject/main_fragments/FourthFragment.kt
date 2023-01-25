package com.example.finalproject.main_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.finalproject.R

class FourthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nutritionType = arguments?.getString("nutritionType")
        val txt = view.findViewById<TextView>(R.id.nutrition_text)

        //display different content depending on which nutrition plan was created
        if (nutritionType == "0") {
            txt.text = "Bulking Plan"
        } else if (nutritionType == "1") {
            txt.text = "Cutting Plan"
        }else if (nutritionType == "2") {
            txt.text = "Maintenance Plan"
        }else if (nutritionType == "3") {
            txt.text = "Fasting Plan"
        }else if (nutritionType == "4") {
            txt.text = "Plant-Based Plan"
        }

    }

}