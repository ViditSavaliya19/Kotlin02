package com.example.kotlin02.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlin02.fragment.ChatFragment
import com.example.kotlin02.fragment.StatusFragment

class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {

        var f1 = when(position)
        {
            0-> ChatFragment()
            1-> StatusFragment()
            2-> ChatFragment()
            else -> StatusFragment()

        }
        return f1
    }
}