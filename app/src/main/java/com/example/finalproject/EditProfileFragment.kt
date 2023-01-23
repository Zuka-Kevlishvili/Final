package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class EditProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val saveButton = view.findViewById<Button>(R.id.save_button)
        val editName = view.findViewById<EditText>(R.id.editName)
        val editAge = view.findViewById<EditText>(R.id.editAge)
        val editHeight = view.findViewById<EditText>(R.id.editHeight)
        val editWeight = view.findViewById<EditText>(R.id.editWeight)

        val context = activity

        saveButton.setOnClickListener {

            if (editName.text.toString().length > 0 &&
                    editAge.text.toString().length > 0 &&
                    editHeight.text.toString().length > 0 &&
                    editWeight.text.toString().length > 0) {

                var user = User(editName.text.toString(), editAge.text.toString().toInt(),
                    editHeight.text.toString().toInt(), editWeight.text.toString().toInt())

                var db = context?.let { it1 -> DatabaseHandler(it1) }

                db?.insertData(user)

            } else {
                Toast.makeText(activity, "Please fill in all fields and try again.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}