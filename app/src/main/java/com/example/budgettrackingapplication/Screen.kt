package com.example.budgettrackingapplication

sealed class Screen(val route: String){
    object Landing: Screen(route = "landing_page")
    object Login: Screen(route = "login_page")
}
