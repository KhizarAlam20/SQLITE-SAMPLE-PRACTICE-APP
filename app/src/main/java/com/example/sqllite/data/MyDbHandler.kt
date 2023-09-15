package com.example.sqllite.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class MyDbHandler(context: Context) :
    SQLiteOpenHelper(context, DATABSE_NAME, null, DATABASE_VERSION) {

    //params
    companion object {
        public const val DATABASE_VERSION = 1
        public const val DATABSE_NAME = "EmployeeDatabase"
        public const val TABLE_NAME = "EmployeeTable"

        public const val KEY_ID = "_id"
        public const val KEY_NAME = "name"
        public const val KEY_MAIL = "mail"
    }

    //db handler
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACT_TABLE = ("CREATE TABLE" + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAME + "TEXT," +
                KEY_MAIL + "TEXT)")

        db?.execSQL(CREATE_CONTACT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXIST" + TABLE_NAME)
        onCreate(db)
    }

    /*function to add employee*/
    fun addEmployee(emp: empModel): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, emp.name)
        contentValues.put(KEY_MAIL, emp.email)

        // inserting row
        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()

        return success
    }

    /*Method to read data*/
    @SuppressLint("Range")
    fun viewEmployee(): ArrayList<empModel> {
        val empList: java.util.ArrayList<empModel> = ArrayList<empModel>()

        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var name: String
        var email: String

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                email = cursor.getString(cursor.getColumnIndex(KEY_MAIL))

                val emp = empModel(id = id, name = name, email = email)
                empList.add(emp)

            } while (cursor.moveToNext())
        }
        return empList
    }

    /*update*/
    fun updateEmployee(emp: empModel): Int {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, emp.name)
        contentValues.put(KEY_MAIL, emp.email)

        val success = db.update(TABLE_NAME, contentValues, KEY_ID + "=" + emp.id, null)
        db.close()
        return success
    }
}