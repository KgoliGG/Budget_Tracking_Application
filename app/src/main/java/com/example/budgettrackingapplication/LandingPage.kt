package com.example.budgettrackingapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettrackingapplication.ui.theme.BudgetTrackingApplicationTheme
import com.example.budgettrackingapplication.ui.theme.montserrat

class LandingPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetTrackingApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
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
            style = androidx.compose.ui.text.TextStyle(
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
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 8.05.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 2.01.sp,
            )
        )
    }
}

@Composable
private fun linearGradient(
    gradient: Boolean,
    colors: List<Color>
): Brush {
    val endOffset = if (gradient){
        Offset(0f, Float.POSITIVE_INFINITY)
    }
    else
    {
        Offset(Float.POSITIVE_INFINITY,0f)
    }
    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset,
    )
}

@Composable
private fun ListOptions(modifier: Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .offset(0.dp, 55.dp)
    ) {
        Text(
            text = "Set a Budget".uppercase(),
            modifier = Modifier
                .padding(0.dp,0.dp),
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
                .padding(0.dp, 10.dp)
                .width(width = 25.dp)
                .height(height = 1.dp)
                .background(color = Color(0xFFFFFFFF))
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = "Track your Spending".uppercase(),
            modifier = Modifier
                .padding(0.dp,0.dp),
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
                .padding(0.dp, 10.dp)
                .width(width = 25.dp)
                .height(height = 1.dp)
                .background(color = Color(0xFFFFFFFF))
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = "Increase Savings".uppercase(),
            modifier = Modifier
                .padding(0.dp,0.dp),
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
                .padding(0.dp, 10.dp)
                .width(width = 25.dp)
                .height(height = 1.dp)
                .background(color = Color(0xFFFFFFFF))
                .clip(RoundedCornerShape(10.dp))
        )
    }
}

@Composable
public fun Background(){
    val gradientColors = listOf(
        Color(0xFF4F517D),
        Color(0xFF3D4267),
        Color(0xFF1A233A),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = linearGradient(
                    gradient = true,
                    colors = gradientColors,
                )
            )
    )
}


@Preview(showBackground = true)
@Composable
fun LandingPagePreview(){
    Background()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
//        modifier = Modifier.padding(10.dp,130.dp)
    ) {
        Heading(name = "Solvio")

    }

}