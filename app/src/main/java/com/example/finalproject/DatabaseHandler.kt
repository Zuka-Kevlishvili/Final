package com.example.finalproject

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "User"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_HEIGHT = "height"
val COL_WEIGHT = "weight"
val COL_ID = "id"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME +" VARCHAR(256),"+
                COL_AGE +" INTEGER,"+
                COL_HEIGHT +" INTEGER,"+
                COL_WEIGHT +" INTEGER)";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData (user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_AGE,user.age)
        cv.put(COL_HEIGHT,user.height)
        cv.put(COL_WEIGHT,user.weight)
        var result = db.insert(TABLE_NAME,null,cv)

        if (result == -1.toLong()) {
            Toast.makeText(context,"Saving data failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context,"Saving data was successful", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("Range")
    fun readData () : MutableList<User> {
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)

        if(result.moveToFirst()) {
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
                user.height = result.getString(result.getColumnIndex(COL_HEIGHT)).toInt()
                user.weight = result.getString(result.getColumnIndex(COL_WEIGHT)).toInt()
                list.add(user)
            } while (result.moveToNext())
        }

        result.close()
        db.close()

        return list
    }

}