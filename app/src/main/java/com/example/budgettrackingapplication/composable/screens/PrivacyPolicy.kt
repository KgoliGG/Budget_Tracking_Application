package com.example.budgettrackingapplication.composable.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.composable.components.HeadingText

@Composable
fun PrivacyPoliciesScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 100.dp, end = 20.dp, bottom = 50.dp)
    ) {
        HeadingText(
            value = "Privacy Policy",
            modifier = Modifier,
            style = TextStyle(
                fontSize = 40.sp
            )
        )


    }
}

@Preview
@Composable
fun PrivacyPoliciesPreview() {
    TermsAndConditionScreen(rememberNavController())
}