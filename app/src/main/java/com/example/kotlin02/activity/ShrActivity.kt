package com.example.kotlin02.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin02.Database.DBHelper
import com.example.kotlin02.adapter.StudentAdapter
import com.example.kotlin02.databinding.ActivityShrBinding
import com.example.kotlin02.model.DataModel

class ShrActivity : AppCompatActivity() {

    lateinit var dbHelper: DBHelper
    lateinit var studentAdapter: StudentAdapter

    companion object{
        var datalist = arrayListOf<DataModel>()

    }


    lateinit var shrBinding: ActivityShrBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shrBinding =ActivityShrBinding.inflate(layoutInflater)
        setContentView(shrBinding.root)
         dbHelper = DBHelper(this)

        shrBinding.btnSubmit.setOnClickListener {
            dbHelper.insertData("Ronak","5252525252","3")
            datalist  = dbHelper.readData()
            rvSteUP()
        }

    }
    fun rvSteUP() {
        studentAdapter= StudentAdapter(this)
        var  lm= LinearLayoutManager(this)
        shrBinding.rvData.layoutManager =lm
        shrBinding.rvData.adapter=studentAdapter
    }
    override fun onStart() {
        super.onStart()
        datalist  = dbHelper.readData()
        rvSteUP()
    }



}