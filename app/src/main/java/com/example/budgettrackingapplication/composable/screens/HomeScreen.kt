package com.example.budgettrackingapplication.composable.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.budgettrackingapplication.composable.BackgroundDesign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BackgroundDesign()

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 20.dp,
                    top = 50.dp,
                    end = 20.dp,
                    bottom = 50.dp
                )
        ) {

        }
    }
}

@Preview
@Composable
fun previewHomeScreeen(){
    HomeScreen(rememberNavController())
}