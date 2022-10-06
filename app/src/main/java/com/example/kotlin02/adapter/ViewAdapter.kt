package com.example.kotlin02.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.kotlin02.R
import com.example.kotlin02.fragment.ChatFragment

class ViewAdapter(val chatFragment: ChatFragment, val imageLIst: ArrayList<Int>) : PagerAdapter() {

    override fun getCount(): Int {
        return imageLIst.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var view =
            LayoutInflater.from(chatFragment.activity).inflate(R.layout.view_item, container, false)
        var imageItem = view.findViewById<ImageView>(R.id.imageItem)
        imageItem.setImageResource(imageLIst[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       container.removeView(`object` as View)

    }

}