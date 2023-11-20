package com.example.budgettrackingapplication.composable

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "users.sqlite"
        private const val DATABASE_VERSION = 1

        private const val TABLE_USERS = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_NAME = "fullName"
        private const val COLUMN_AGE = "age"
        private const val COLUMN_GENDER = "gender"
    }

    override fun onCreate(db: SQLiteDatabase) {
            val createTableQuery = "CREATE TABLE $TABLE_USERS (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY," +
                    "$COLUMN_EMAIL TEXT NOT NULL,"  +
                    "$COLUMN_PASSWORD TEXT NOT NULL," +
                    "$COLUMN_NAME TEXT," +
                    "$COLUMN_AGE INT," +
                    "$COLUMN_GENDER TEXT)"

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

    fun addUser(user: User, id: UserID): Long
    {
        val values = ContentValues().apply {
            put(COLUMN_ID, id.id)
            put(COLUMN_EMAIL, user.email)
            put(COLUMN_PASSWORD, user.password)
        }
        return writableDatabase.insert(TABLE_USERS, null, values)
    }

    fun isUserExists(email: String): Boolean {
        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ?"
        val cursor = readableDatabase.rawQuery(query, arrayOf(email))
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }

    fun checkCredentials(loginuser: LoginUser): Boolean {
        val p0 = this.writableDatabase
        val query = "SELECT " +
                "$COLUMN_ID" +
                "FROM " +
                "$TABLE_USERS " +
                "WHERE " +
                "$COLUMN_EMAIL = '${loginuser.email}' " +
                "AND " +
                "$COLUMN_PASSWORD = '${loginuser.password}'"
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

    fun fetchuserid(loginuser: LoginUser) : Cursor? {
        val query = "SELECT " +
                "$COLUMN_ID" +
                "FROM " +
                "$TABLE_USERS " +
                "WHERE " +
                "$COLUMN_EMAIL = '${loginuser.email}' " +
                "AND " +
                "$COLUMN_PASSWORD = '${loginuser.password}'"
        val id = readableDatabase.rawQuery(query,null)
        return id
    }

    fun updateUserData(id: Cursor?, user: UserDetails) : Int {
        val values = ContentValues().apply {
            put(COLUMN_NAME, user.fullName)
            put(COLUMN_AGE, user.age)
            put(COLUMN_PASSWORD, user.gender)

        }
        val whereClause = "$COLUMN_ID = ?"
        Log.d("ID Values","{${whereClause}}")
        val whereArgs = arrayOf(id.id.toString())

        return writableDatabase.update(TABLE_USERS, values, whereClause, whereArgs)
    }

}