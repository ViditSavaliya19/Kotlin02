package com.example.kotlin02.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin02.R
import com.example.kotlin02.adapter.StatusAdapter
import com.example.kotlin02.databinding.FragmentStatusBinding
import com.example.kotlin02.model.StatusModel
import com.google.android.material.navigation.NavigationView


class StatusFragment : Fragment() {

    lateinit var statusAdapter: StatusAdapter
    lateinit var statusBinding: FragmentStatusBinding
    var list = arrayListOf<StatusModel>()
    var i = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statusBinding =
            FragmentStatusBinding.bind(inflater.inflate(R.layout.fragment_status, container, false))
        initClick();
        rvSetUp(list)
        return statusBinding.root
    }

    private fun rvSetUp(l1: ArrayList<StatusModel>) {
        statusAdapter = StatusAdapter(activity, l1)
        var lm = LinearLayoutManager(activity)
        statusBinding.rvStatus.layoutManager = lm
        statusBinding.rvStatus.adapter = statusAdapter
    }


    private fun initClick() {
        statusBinding.imgMenu.setOnClickListener {
            statusBinding.drawerLayout.openDrawer(GravityCompat.START)
        }
        statusBinding.floatAddBtn.setOnClickListener {
            insertDailog()
        }

    }

    fun insertDailog()
    {
        var dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.insert_item)


        var edtId=dialog.findViewById<EditText>(R.id.edtId);
        var edtName=dialog.findViewById<EditText>(R.id.edtName);
        var edtStd=dialog.findViewById<EditText>(R.id.edtStd);
        var btnSubmit=dialog.findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {

           var s1 = StatusModel(edtId.text.toString(),edtName.text.toString(),edtStd.text.toString())
            list.add(s1)
            statusAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }

        dialog.show()
    }


}
