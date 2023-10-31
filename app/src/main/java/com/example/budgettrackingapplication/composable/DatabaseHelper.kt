package com.example.budgettrackingapplication.composable

import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "users.sqlite"
        private const val DATABASE_VERSION = 1

        private const val TABLE_USERS = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
            val createTableQuery = "CREATE TABLE $TABLE_USERS ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_EMAIL TEXT, $COLUMN_PASSWORD TEXT)"

        try {
            db.execSQL(createTableQuery)
        }
        catch (e: SQLException) {
            print(e)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_USERS"
        db.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun addUser(user: User): Long
    {
        val values = ContentValues().apply {
            put(COLUMN_ID, user.id)
            put(COLUMN_EMAIL, user.email)
            put(COLUMN_PASSWORD, user.password)
        }
        return writableDatabase.insert(TABLE_USERS, null, values)
    }

    fun checkCredentials(user: LoginUser): Boolean {
//        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
//        val cursor = readableDatabase.rawQuery(query, arrayOf(user.email, user.password))
//        val exists = cursor.count > 0
//        cursor.close()
//        return exists
        val p0 = this.writableDatabase
        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = '${user.email}' AND $COLUMN_PASSWORD = '${user.password}'"
        val cursor = p0.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        else{
            cursor.close()
            return true
        }
    }

    fun isUserExists(email: String): Boolean {
        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ?"
        val cursor = readableDatabase.rawQuery(query, arrayOf(email))
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }


    fun getUserByEmail(email: String): User? {
        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ?"
        val cursor = readableDatabase.rawQuery(query, arrayOf(email))
        val user = if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex(COLUMN_ID)
            val passwordIndex = cursor.getColumnIndex(COLUMN_PASSWORD)

            val id = cursor.getLong(idIndex)
            val password = cursor.getString(passwordIndex)

            User(id.toInt(), email, password)
        } else {
            null
        }
        cursor.close()
        return user
    }
}