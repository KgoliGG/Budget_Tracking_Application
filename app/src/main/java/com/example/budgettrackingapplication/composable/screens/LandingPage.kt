package com.example.budgettrackingapplication.composable.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.R
import com.example.budgettrackingapplication.composable.BackgroundDesign
import com.example.budgettrackingapplication.navigation.Screen
import com.example.budgettrackingapplication.ui.theme.montserrat


@Composable
fun LandingPage(navController: NavController) {
    BackgroundDesign()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
//            .padding(10.dp,130.dp)
    ) {
        Text(
            text = "Welcome to".uppercase(),
            fontSize = 16.sp,
            fontFamily = montserrat,
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
            letterSpacing = 1.6.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()

        )

        Text(
            text = "Solvio".uppercase(),
            style = TextStyle(
                fontSize = 40.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 24.sp,

                )
        )
        Text(
            text = "Helping you track your expenditure".uppercase(),
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 2.01.sp,
            )
        )

        Box(
            modifier = Modifier
                .padding(top = 55.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_mark),
                contentDescription = null,
                Modifier
                    .size(105.dp, 175.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(top = 55.dp)
                .fillMaxWidth()
                .fillMaxHeight(.4f)
        ) {
            Text(
                text = "Set a Budget".uppercase(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                )
            )

            Box(
                modifier = Modifier
                    .width(width = 25.dp)
                    .height(height = 1.dp)
                    .background(color = Color(0xFFFFFFFF))
                    .clip(RoundedCornerShape(10.dp))
            )

            Text(
                text = "Track your Spending".uppercase(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                )
            )

            Box(
                modifier = Modifier
                    .width(width = 25.dp)
                    .height(height = 1.dp)
                    .background(color = Color(0xFFFFFFFF))
                    .clip(RoundedCornerShape(10.dp))
            )

            Text(
                text = "Increase Savings".uppercase(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                )
            )
        }

//        val login = LocalContext.current

        Box(
            modifier = Modifier
                .padding(top = 50.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate(
                        route = Screen.RegistrationPage.name
                    )
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF4F517D)),
                shape = RoundedCornerShape(10.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Get Started".uppercase(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        letterSpacing = 1.6.sp,
                    )
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LandingPagePreview() {
    BackgroundDesign()
    LandingPage(rememberNavController())
}