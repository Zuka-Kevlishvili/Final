package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class SecondFragment : Fragment() {

    private lateinit var workoutsAdapter: MyWorkoutsAdapter
    private lateinit var nutritionAdapter: MyNutritionAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var workoutsArrayList: ArrayList<Workouts>
    private lateinit var nutritionArrayList: ArrayList<Nutrition>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contentType = arguments?.getString("contentType")
        if (contentType == "workouts") {
            workoutsDataInit()
            val layoutManager = LinearLayoutManager(context)
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            workoutsAdapter = MyWorkoutsAdapter(workoutsArrayList)
            recyclerView.adapter = workoutsAdapter
        } else if (contentType == "nutrition") {
            nutritionDataInit()
            val layoutManager = LinearLayoutManager(context)
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            nutritionAdapter = MyNutritionAdapter(nutritionArrayList)
            recyclerView.adapter = nutritionAdapter
        }
    }

    private fun workoutsDataInit() {
        workoutsArrayList = arrayListOf<Workouts>()
        imageId = arrayOf(
            R.drawable.chest,
            R.drawable.abs,
            R.drawable.back,
            R.drawable.forearms,
            R.drawable.biceps,
            R.drawable.triceps,
            R.drawable.shoulders,
            R.drawable.legs,
            R.drawable.obliques
        )

        heading = arrayOf(
            getString(R.string.w_1),
            getString(R.string.w_2),
            getString(R.string.w_3),
            getString(R.string.w_4),
            getString(R.string.w_5),
            getString(R.string.w_6),
            getString(R.string.w_7),
            getString(R.string.w_8),
            getString(R.string.w_9)
        )

        for(i in imageId.indices) {
            val workouts = Workouts(imageId[i], heading[i])
            workoutsArrayList.add(workouts)
        }
    }

    private fun nutritionDataInit() {
        nutritionArrayList = arrayListOf<Nutrition>()
        imageId = arrayOf(
            R.drawable.bulk,
            R.drawable.cut,
            R.drawable.maintain,
            R.drawable.fasting,
            R.drawable.plant
        )

        heading = arrayOf(
            getString(R.string.w_10),
            getString(R.string.w_11),
            getString(R.string.w_12),
            getString(R.string.w_13),
            getString(R.string.w_14)
        )

        for(i in imageId.indices) {
            val nutrition = Nutrition(imageId[i], heading[i])
            nutritionArrayList.add(nutrition)
        }
    }
}