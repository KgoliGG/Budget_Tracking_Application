package com.example.budgettrackingapplication.composable.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomNav(){
        var currentSelectedScreenId by remember { mutableStateOf("") }

    BottomAppBar(
        containerColor = Color(0xFFDCCFEC),
//        cutoutShape = CircleShape,
        contentPadding = PaddingValues(horizontal = 50.dp),


    ) {

    }
}
@Composable
fun NavItem(navController: NavController, onClick:() -> Unit){

}