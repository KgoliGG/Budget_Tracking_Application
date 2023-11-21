package com.example.budgettrackingapplication.composable

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