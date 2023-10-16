package com.example.budgettrackingapplication.composable.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettrackingapplication.ui.theme.montserrat

@Composable
fun HeadingText(value: String, modifier: Modifier, style: TextStyle){
    Text(
        text = value.uppercase(),
        style = TextStyle(
            fontSize = 60.sp,
            fontFamily = montserrat,
            fontWeight = FontWeight(700),
            color = Color(0XFFFFFFFF),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp)
    )
}

@Composable
fun SubHeading(value: String){
    Text(
        text = value,
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = montserrat,
            color = Color(0xFFFFFFFF),
            letterSpacing = 0.24.sp,
        ),
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(0.9f)
    )
}

@Composable
fun ErrorMessage(value: String){
    Text(
        text = value,
        style = TextStyle(
            color = Color.Red,
            fontFamily = montserrat,
            fontSize = 12.sp,
            fontWeight = FontWeight(500)
        )
    )
}

@Composable
fun BaseSpacer(){
    Spacer(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxWidth()
    )
}