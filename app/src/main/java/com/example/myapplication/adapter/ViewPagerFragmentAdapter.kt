package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.fragments.FragmentFirst
import com.example.myapplication.fragments.FragmentNote
import com.example.myapplication.fragments.FragmentSecond

class ViewPagerFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount() = 3



    override fun createFragment(position: Int): Fragment {
        return when (position){
            0-> FragmentFirst()
            1-> FragmentSecond()
            2-> FragmentNote()
            else -> FragmentFirst()
        }
    }
}