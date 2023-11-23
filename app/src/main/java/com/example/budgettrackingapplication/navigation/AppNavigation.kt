package com.example.budgettrackingapplication.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.composable.screens.AddScreen
import com.example.budgettrackingapplication.composable.screens.CategoriesScreen
import com.example.budgettrackingapplication.composable.screens.ExpensesScreen
import com.example.budgettrackingapplication.composable.screens.LandingPage
import com.example.budgettrackingapplication.composable.screens.LoginPage
import com.example.budgettrackingapplication.composable.screens.PrivacyPoliciesScreen
import com.example.budgettrackingapplication.composable.screens.RegistrationPage
import com.example.budgettrackingapplication.composable.screens.ReportsScreen
import com.example.budgettrackingapplication.composable.screens.SettingsScreen
import com.example.budgettrackingapplication.composable.screens.TermsAndConditionScreen
import com.example.budgettrackingapplication.composable.screens.UserSetup


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
        composable(route = Screen.UserSetup.name) {
            UserSetup(navController = navController)
        }
        composable(route = Screen.ExpensesScreen.name) {
            ExpensesScreen(navController = navController)
        }
        composable(route = Screen.TermsAndCondition.name){
            TermsAndConditionScreen(navController = navController)
        }
        composable(route = Screen.PrivacyPolicies.name){
            PrivacyPoliciesScreen(navController = navController)
        }
        composable(route = Screen.ReportsScreen.name) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ReportsScreen()
            }
        }
        composable(route = Screen.AddScreen.name) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AddScreen(navController)
            }
        }
        composable(route = Screen.SettingsScreen.name) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                SettingsScreen(navController)
            }
        }
        composable(route = Screen.SettingsCategoriesScreen.name) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CategoriesScreen(navController)
            }
        }
    }
}