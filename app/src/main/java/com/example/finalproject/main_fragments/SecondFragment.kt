package com.example.finalproject.main_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.*
import com.example.finalproject.adapters.MyNutritionAdapter
import com.example.finalproject.adapters.MyWorkoutsAdapter
import com.example.finalproject.data.Nutrition
import com.example.finalproject.data.Workouts


class SecondFragment : Fragment() {

    private lateinit var workoutsAdapter: MyWorkoutsAdapter
    private lateinit var nutritionAdapter: MyNutritionAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var workoutsArrayList: ArrayList<Workouts>
    private lateinit var nutritionArrayList: ArrayList<Nutrition>

    private lateinit var imageId : Array<Int>
    private lateinit var heading : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // read which button was pressed using bundle and display different recyclerView depending on that
        val contentType = arguments?.getString("contentType")
        if (contentType == "workouts") {
            workoutsDataInit()
            val layoutManager = LinearLayoutManager(context)
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            workoutsAdapter = MyWorkoutsAdapter(workoutsArrayList)
            recyclerView.adapter = workoutsAdapter
            workoutsAdapter.setOnItemClickListener(object : MyWorkoutsAdapter.OnItemClickListener {

                //when one of the items are clicked nav to the third fragment and put in extra bundle to discover which item was pressed
                override fun onItemClick(position: Int) {
                    val bundle = Bundle()
                    bundle.putString("workoutType", "$position")
                    findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
                }

            })
        } else if (contentType == "nutrition") {
            nutritionDataInit()
            val layoutManager = LinearLayoutManager(context)
            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            nutritionAdapter = MyNutritionAdapter(nutritionArrayList)
            recyclerView.adapter = nutritionAdapter
            nutritionAdapter.setOnItemClickListener(object :
                MyNutritionAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val bundle = Bundle()
                    bundle.putString("nutritionType", "$position")
                    findNavController().navigate(R.id.action_secondFragment_to_fourthFragment, bundle)
                }
            })
        }
    }

    // workouts data initialization for recyclerView
    private fun workoutsDataInit() {
        workoutsArrayList = arrayListOf()
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

    // nutrition data initialization for recyclerView
    private fun nutritionDataInit() {
        nutritionArrayList = arrayListOf()
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