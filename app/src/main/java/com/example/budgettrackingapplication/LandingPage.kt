package com.example.budgettrackingapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.budgettrackingapplication.composable.BackgroundDesign
import com.example.budgettrackingapplication.composable.LoginPage
import com.example.budgettrackingapplication.composable.LoginPagePreview
import com.example.budgettrackingapplication.ui.theme.BudgetTrackingApplicationTheme
import com.example.budgettrackingapplication.ui.theme.montserrat

class LandingPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetTrackingApplicationTheme {
                val navController: NavController
                navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome" ){
                    navigation(
                        startDestination = "welcome",
                        route = "auth"
                    ){
                        composable("landing"){

                        }
                        composable("login"){

                        }
                    }

                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LandingPagePreview()
                }
            }
        }
    }
}

@Composable
inline fun <reified T :ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?:return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}


@Composable
private fun Heading(name: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
//            .padding(10.dp,130.dp)
    ) {
        Text(
            text = "Welcome to".uppercase(),
            fontFamily = montserrat,
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
            letterSpacing = 1.6.sp,
            modifier = Modifier
                .width(131.dp)
                .height(20.dp)
        )
        Text(
            text = name.uppercase(),
            style = TextStyle(
                fontSize = 32.2.sp,
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
                fontSize = 8.05.sp,
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
                    .size(90.dp,150.dp)
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
                    fontSize = 12.sp,
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
                    fontSize = 12.sp,
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
                    fontSize = 12.sp,
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
            .padding(top = 75.dp)
        ){
            Button(
                onClick = {
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF4F517D)),
                shape = RoundedCornerShape(10.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                ),
                modifier = Modifier
                    .width(200.dp)
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
fun LandingPagePreview(){
    BackgroundDesign()
    Box(modifier = Modifier.padding(top = 130.dp)){
        Heading(name = "Solvio")
    }
}