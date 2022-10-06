package com.example.kotlin02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlin02.databinding.ActivityMain2Binding
import com.example.kotlin02.databinding.ActivityMainBinding
import com.example.kotlin02.fragment.ChatFragment
import com.example.kotlin02.fragment.StatusFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(StatusFragment())

        binding.btnChat.setOnClickListener {
            loadFragment(ChatFragment())
        }


        binding.btnStatus.setOnClickListener {
          loadFragment(StatusFragment())
        }

    }

    fun loadFragment(f1:Fragment)
    {
        var fm = supportFragmentManager.beginTransaction()
        fm.replace(R.id.framContainer,f1)
        fm.commitAllowingStateLoss()
    }





}