package com.example.kotlin02.Database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.kotlin02.model.DataModel

class DBHelper(context: Context?) : SQLiteOpenHelper(context, "RNW.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        var query =
            "CREATE TABLE std (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,mobile TEXT,std TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertData(n1: String, m1: String, s1: String) {
        var db = writableDatabase

        var contentvalue = ContentValues()
        contentvalue.put("name", n1)
        contentvalue.put("mobile", m1)
        contentvalue.put("std", s1)

        db.insert("std", null, contentvalue)
    }

    @SuppressLint("Range")
    fun readData(): ArrayList<DataModel> {
        var datalist = arrayListOf<DataModel>()
        var db = readableDatabase
        var query = "SELECT * FROM std"
        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id")).toString()
                var name = cursor.getString(cursor.getColumnIndex("name")).toString()
                var mobile = cursor.getString(cursor.getColumnIndex("mobile")).toString()
                var std = cursor.getString(cursor.getColumnIndex("std")).toString()

                var d1 = DataModel(id, name, mobile, std)
                datalist.add(d1)

            } while (cursor.moveToNext())
        }

        return datalist;
    }

    fun deleteData(id: String) {
        var db = writableDatabase
        db.delete("std", "id = $id", null);
    }

    fun updateData(name: String, std: String, mobile: String, id: String) {
        var db = writableDatabase
        var contentValues = ContentValues()
        contentValues.put("name", name)
        contentValues.put("std", std)
        contentValues.put("mobile", mobile)


        db.update("std", contentValues, "id = $id", null)
    }


}