package com.example.kotlin02.adapter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin02.Database.DBHelper
import com.example.kotlin02.R
import com.example.kotlin02.activity.ShrActivity
import com.example.kotlin02.activity.ShrActivity.Companion.datalist
import com.example.kotlin02.model.DataModel
import com.example.kotlin02.model.StatusModel

class StudentAdapter(val shrActivity: ShrActivity) :
    RecyclerView.Adapter<StudentAdapter.ViewDataHolder>() {

    class ViewDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtID = itemView.findViewById<TextView>(R.id.txtID)
        var txtName1 = itemView.findViewById<TextView>(R.id.txtName1)
        var txtStd = itemView.findViewById<TextView>(R.id.txtStd)
        var txtMobile = itemView.findViewById<TextView>(R.id.txtMobile)
        var imgDelete = itemView.findViewById<ImageView>(R.id.imgDelete)
        var imgUpdate = itemView.findViewById<ImageView>(R.id.imgUpdate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewDataHolder {
        var view = LayoutInflater.from(shrActivity).inflate(R.layout.dataitem, parent, false)
        return ViewDataHolder(view)
    }

    override fun onBindViewHolder(holder: ViewDataHolder, position: Int) {

        holder.txtID.text = datalist.get(position).id
        holder.txtStd.text = datalist.get(position).std
        holder.txtMobile.text = datalist.get(position).mobile
        holder.txtName1.text = datalist.get(position).name
        var db = DBHelper(shrActivity)

        holder.imgDelete.setOnClickListener {
            db.deleteData(datalist.get(position).id)
            datalist.removeAt(position)
            notifyDataSetChanged()
        }


        holder.imgUpdate.setOnClickListener {
            updateDailog(position)
        }
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


    fun updateDailog(position: Int) {
        var dialog = Dialog(shrActivity)
        dialog.setContentView(R.layout.insert_item)

        var edtId = dialog.findViewById<EditText>(R.id.edtId);
        var edtName = dialog.findViewById<EditText>(R.id.edtName);
        var edtStd = dialog.findViewById<EditText>(R.id.edtStd);
        var btnSubmit = dialog.findViewById<Button>(R.id.btnSubmit)

        edtId.setText(datalist.get(position).mobile)
        edtName.setText(datalist.get(position).name)
        edtStd.setText(datalist.get(position).std)

        btnSubmit.setOnClickListener {

            var dbHelper = DBHelper(shrActivity)
            dbHelper.updateData(
                edtName.text.toString(),
                edtStd.text.toString(),
                edtId.text.toString(),
                datalist.get(position).id
            )
            datalist[position] = DataModel(  datalist.get(position).id, edtName.text.toString(),  edtId.text.toString(), edtStd.text.toString(),)
//            datalist[position] = StatusModel(edtId.text.toString(), edtName.text.toString(), edtStd.text.toString())
            notifyDataSetChanged()
            dialog.dismiss()
        }
        dialog.show()
    }


}