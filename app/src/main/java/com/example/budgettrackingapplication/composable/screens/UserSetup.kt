package com.example.budgettrackingapplication.composable.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.composable.BackgroundDesign
import com.example.budgettrackingapplication.ui.theme.montserrat

@Composable
fun UserSetup(navController: NavController){

    BackgroundDesign()

    val username = remember { mutableStateOf("") }

    val userage = remember { mutableStateOf("") }

    val radioOptions = listOf("Male", "Female", "Woke")

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Text(
            text = "Set your personal information".uppercase(),
            style = TextStyle(
                fontSize = 41.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0XFFFFFFFF),
            ),
            modifier = Modifier
                .padding(top = 100.dp)
        )

        Text(
            text = "Please input your personal details, for us to evaluate your budget information.",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
            )
        )

        Spacer(
            modifier = Modifier.
            padding(10.dp)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            value = username.value,
            onValueChange = { username.value = it },
            label = {
                Text(
                    text = "Full Name",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        letterSpacing = .24.sp
                    ),
                    modifier = Modifier.padding()
                )
            },
            placeholder = {
                Text(
                    text = "",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        letterSpacing = .24.sp
                    )
                )

            },
            singleLine = true
        )

        Spacer(
            modifier = Modifier
                .padding(5.dp)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            value = userage.value,
            onValueChange = { userage.value = it },
            label = {
                Text(
                    text = "Age",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        letterSpacing = .24.sp
                    ),
                    modifier = Modifier.padding()
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text(
                    text = "",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(400),
                        letterSpacing = .24.sp
                    )
                )

            },
            singleLine = true
        )

        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )

        Text(
            text = "Gender",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(600),
                color = Color(0XFFFFFFFF),
            ),
            modifier = Modifier.padding(5.dp)
        )

        Spacer(
            modifier = Modifier
                .padding(5.dp)
        )

        radioOptions.forEach { text ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                )
                Text(
                    text = text,
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = montserrat,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        letterSpacing = .24.sp,
                    ),
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }

        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )

        Button(
            onClick = {

            },
//            enabled = email.value.isNotEmpty() && password.value.isNotEmpty() && termsChecked.value,
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
                text = "Create Account".uppercase(),
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

@Preview(showBackground = true)
@Composable
private fun UserSetupPreview(){
    UserSetup(rememberNavController())
}