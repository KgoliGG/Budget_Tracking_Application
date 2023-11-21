package com.example.budgettrackingapplication.composable

import android.content.Context
import android.database.Cursor

// Function to store the user ID in cache
fun storeUserIDInCache(context: Context, userID: String) {
    val sharedPreferences = context.getSharedPreferences("UserCache", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("userID", userID.toString())
    editor.apply()
}

// Function to retrieve the user ID from cache
fun getUserIDFromCache(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences("UserCache", Context.MODE_PRIVATE)
    return sharedPreferences.getString("userID", null)
}