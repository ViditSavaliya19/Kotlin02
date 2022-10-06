package com.example.kotlin02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.kotlin02.adapter.TabAdapter
import com.example.kotlin02.databinding.ActivityMain2Binding
import com.google.android.material.tabs.TabLayout

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Chat"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Status"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Call"))


        //Viewpager
        var viewAdapter = TabAdapter(supportFragmentManager)
        binding.viewScreenPager.adapter = viewAdapter

        binding.viewScreenPager.setOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                binding.tabLayout
            )
        )

        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                    binding.viewScreenPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}