package com.example.finalproject.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.finalproject.data.DatabaseHandler
import com.example.finalproject.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val editButton = view.findViewById<Button>(R.id.edit_button)
        val dataResult = view.findViewById<TextView>(R.id.dataResult)


        val context = activity

        //get the last input in the data
        val db = context?.let { DatabaseHandler(it) }
        val data = db?.readData()
        dataResult.text = ""

        if (data != null) {
            dataResult.append("Name: " + data[data.size-1].name + "\n" + "Age: " + data[data.size-1].age + "\n" + "Height: " + data[data.size-1].height + "\n" + "Weight: " + data[data.size-1].weight + "\n")
        } else {
            dataResult.append("Name: " + "\n" + "Age: " + "\n" + "Height: " + "\n" + "Weight: " + "\n")
        }

        // navigate to EditProfileFragment when edit button is pressed
        editButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }
    }
}