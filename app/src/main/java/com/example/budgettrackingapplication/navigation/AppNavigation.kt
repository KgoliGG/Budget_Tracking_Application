package com.example.budgettrackingapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.composable.screens.LandingPage
import com.example.budgettrackingapplication.composable.screens.LoginPage
import com.example.budgettrackingapplication.composable.screens.RegistrationPage


@Composable
fun AppNavigation(){
    val navController : NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.LandingPage.name) {
        composable(route = Screen.LandingPage.name) {
            LandingPage(navController = navController)
        }
        composable(route = Screen.RegistrationPage.name) {
            RegistrationPage(navController = navController)
        }
        composable(route = Screen.LoginPage.name) {
            LoginPage(navController = navController)
        }
    }
}