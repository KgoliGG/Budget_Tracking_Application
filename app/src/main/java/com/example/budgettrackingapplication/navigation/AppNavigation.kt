package com.example.budgettrackingapplication.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.composable.pages.AddScreen
import com.example.budgettrackingapplication.composable.pages.CategoriesScreen
import com.example.budgettrackingapplication.composable.pages.ExpensesScreen
import com.example.budgettrackingapplication.composable.pages.LandingPage
import com.example.budgettrackingapplication.composable.pages.LoginPage
import com.example.budgettrackingapplication.composable.pages.PrivacyPoliciesScreen
import com.example.budgettrackingapplication.composable.pages.RegistrationPage
import com.example.budgettrackingapplication.composable.pages.ReportsScreen
import com.example.budgettrackingapplication.composable.pages.SettingsScreen
import com.example.budgettrackingapplication.composable.pages.TermsAndConditionScreen
import com.example.budgettrackingapplication.composable.pages.UserSetup


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
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ExpensesScreen(navController = navController)
            }
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
                AddScreen(navController = navController)
            }
        }
        composable(route = Screen.SettingsScreen.name) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                SettingsScreen(navController = navController)
            }
        }
        composable(route = Screen.SettingsCategoriesScreen.name) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CategoriesScreen(navController = navController)
            }
        }
    }
}