package com.example.finalproject.main_fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.finalproject.R
import com.example.finalproject.exercise_fragments.ExerciseFragment1
import com.example.finalproject.exercise_fragments.ExerciseFragment2
import com.example.finalproject.exercise_fragments.ExerciseFragment3
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ThirdFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        viewPager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

                tab.text = when (position) {
                    0 -> "Workout 1"
                    1 -> "Workout 2"
                    2 -> "Workout 3"
                    else -> throw IllegalArgumentException("Invalid position")
                }

        }.attach()

        return view
    }

    class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {



        override fun getItemCount(): Int {
            // Return the number of tabs you want to display
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            // Create and return the fragments for each tab
            return when (position) {
                0 -> ExerciseFragment1()
                1 -> ExerciseFragment2()
                2 -> ExerciseFragment3()
                else -> throw IllegalArgumentException("Invalid position")
            }
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val workoutType = arguments?.getString("workoutType")
        val txt = view.findViewById<TextView>(R.id.workout_text)

        // display different content depending on which item was pressed
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

