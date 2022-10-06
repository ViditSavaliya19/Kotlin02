package com.example.kotlin02.Database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHalper(context: Context?) : SQLiteOpenHelper(context, "Data.db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var query =
            "CREATE TABLE std (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,std TEXT,mobile TEXT)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun insertData(n1: String, s1: String, m1: String) {
        var db = writableDatabase
        var contentvalue = ContentValues()
        contentvalue.put("name", n1)
        contentvalue.put("std", s1)
        contentvalue.put("mobile", m1)

        db.insert("std", null, contentvalue)
    }


    fun delete(id: String) {
        var db = writableDatabase
        db.delete("std", "id = $id", null)
    }

    @SuppressLint("Range")
    fun readData(): ArrayList<STDData> {

        var list = arrayListOf<STDData>()
        var db = readableDatabase
        var query = "SELECT * FROM std"
        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var std = cursor.getString(cursor.getColumnIndex("std"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))

                var s1 = STDData(id, name, std, mobile)
                list.add(s1)


            } while (cursor.moveToNext());
        }

        return list;
    }


}

data class STDData(val id: String, val name: String, val std: String, val mobile: String)