package com.example.budgettrackingapplication.composable.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.budgettrackingapplication.composable.BackgroundDesign
import com.example.budgettrackingapplication.composable.MenuHeader

@Composable
fun HomeScreen(navController: NavController){

    BackgroundDesign()

    MenuHeader()
}