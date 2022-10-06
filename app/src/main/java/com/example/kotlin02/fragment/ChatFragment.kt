package com.example.kotlin02.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.kotlin02.R
import com.example.kotlin02.adapter.ViewAdapter
import com.example.kotlin02.databinding.FragmentChatBinding
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class ChatFragment : Fragment() {


    var list = arrayListOf<CarouselItem>()
    var imageLIst = arrayListOf<Int>(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground
    )

    lateinit var fbinding : FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fbinding = FragmentChatBinding.inflate(layoutInflater)

        initBinding()
        sliderSetUp()

        return fbinding.root
    }

    private fun initBinding() {


        var viewadapter = ViewAdapter(this@ChatFragment,imageLIst)
        fbinding.viewPager.adapter= viewadapter
    }

    fun sliderSetUp() {
        list.add(
            CarouselItem(
                imageUrl = "https://blog.talkcharge.com/wp-content/uploads/2020/09/Upcoming-Amazon-Sale.jpg",
                caption = "Big sell"
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://s3b.cashify.in/gpro/uploads/2022/02/15183949/Upcoming-Sales-on-Amazon.jpg",
                caption = "Big sell"
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://www.ecommerceceo.com/wp-content/uploads/2021/08/Best-Products-To-Sell-On-Amazon-1024x536-1.jpg",
                caption = "Big sell"
            )
        )

        fbinding.slider.addData(list)
    }
}