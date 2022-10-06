package com.example.kotlin02.adapter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin02.R
import com.example.kotlin02.model.StatusModel

class StatusAdapter(
    val statusFragment: FragmentActivity?,
    val list: ArrayList<StatusModel>,
) :
    RecyclerView.Adapter<StatusAdapter.ViewData>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view =
            LayoutInflater.from(statusFragment).inflate(R.layout.item_list, parent, false)
        return ViewData(view)

    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.txtId.text = list[position].id;
        holder.txtName.text = list[position].name;
        holder.txtStd.text = list[position].std;

        holder.imgDelete.setOnClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
        }

        holder.imgUpdate.setOnClickListener {
            updateDailog(position)
        }


//        holder.txtItem.setOnClickListener {
//                itemclickListner.itemClick(list[position].name)
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtId = itemView.findViewById<TextView>(R.id.txtId)
        var txtName = itemView.findViewById<TextView>(R.id.txtName)
        var txtStd = itemView.findViewById<TextView>(R.id.txtstd)
        var imgDelete = itemView.findViewById<ImageView>(R.id.imgDelete)
        var imgUpdate = itemView.findViewById<ImageView>(R.id.imgUpdate)
    }


    fun updateDailog(position: Int) {
        var dialog = Dialog(statusFragment!!)
        dialog.setContentView(R.layout.insert_item)


        var edtId = dialog.findViewById<EditText>(R.id.edtId);
        var edtName = dialog.findViewById<EditText>(R.id.edtName);
        var edtStd = dialog.findViewById<EditText>(R.id.edtStd);
        var btnSubmit = dialog.findViewById<Button>(R.id.btnSubmit)


        edtId.setText(list.get(position).id)
        edtName.setText(list.get(position).name)
        edtStd.setText(list.get(position).std)

        btnSubmit.setOnClickListener {
            list[position] =
                StatusModel(edtId.text.toString(), edtName.text.toString(), edtStd.text.toString())
            notifyDataSetChanged()
            dialog.dismiss()
        }

        dialog.show()
    }
}