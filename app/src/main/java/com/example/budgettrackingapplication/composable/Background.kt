package com.example.budgettrackingapplication.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.budgettrackingapplication.R


@Composable
fun BackgroundDesign(){
        val gradientColors = listOf(
            Color(0xFF4F517D),
            Color(0xFF3D4267),
            Color(0xFF282F4C),
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = 0.dp,
                    end = 0.dp,
                )
                .alpha(.05f)

        ){
            Image(
                painter = painterResource(id = R.drawable.logomark),
                contentDescription = null,
                modifier = Modifier
                    .size(360.dp,600.dp)
                    .align(alignment = Alignment.BottomCenter)
                    .padding(start = 50.dp)
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