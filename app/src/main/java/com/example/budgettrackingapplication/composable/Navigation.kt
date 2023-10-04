package com.example.budgettrackingapplication.composable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = "landing") {
        composable("landing") {
            LandingPage(rememberNavController())
        }
        composable("registration") {
            RegistrationPage(rememberNavController())
        }
        composable("login") {
            LoginPage(rememberNavController())
        }
    }

}