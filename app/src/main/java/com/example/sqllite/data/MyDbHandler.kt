package com.example.sqllite.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHandler(context : Context) :  SQLiteOpenHelper(context, DATABSE_NAME,null, DATABASE_VERSION){

//params
    companion object {
        public const val DATABASE_VERSION = 1
        public const val DATABSE_NAME = "contacts_db"
        public const val TABLE_NAME = "contacts"

        public const val KEY_ID = "_id"
        public const val KEY_NAME = "name"
        public const val KEY_MAIL = "mail"
    }

    //db handler
    override fun onCreate(db: SQLiteDatabase?) {
       val CREATE_CONTACT_TABLE =("CREATE TABLE"+ TABLE_NAME+"("+
               KEY_ID+" INTEGER PRIMARY KEY,"+
               KEY_NAME+"TEXT,"+
               KEY_MAIL+"TEXT)")

        db?.execSQL(CREATE_CONTACT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}