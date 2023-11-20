package com.example.budgettrackingapplication.composable

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class User(
    val email: String,
    val password: String,
)

//object UserState {
//    val userIDState = mutableStateOf("")
//}

data class UserID(
    val id: Int
)

//fun fetchUserID(
//    userid: Int
//) : UserID{
//
//    return UserID(userid)
//}

data class LoginUser(
    val email: String,
    val password : String
)

data class UserDetails(
    val fullName: String,
    val age: Int,
    val gender: String
)