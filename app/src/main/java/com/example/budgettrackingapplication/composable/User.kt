package com.example.budgettrackingapplication.composable

import androidx.compose.runtime.MutableState

data class User(
    val email: String,
    val password: String,
)

data class UserID(
    val id: Int
)

data class LoginUser(
    val email: String,
    val password : String
)

data class UserDetails(
    val fullName: String,
    val age: Int,
    val gender: String
)