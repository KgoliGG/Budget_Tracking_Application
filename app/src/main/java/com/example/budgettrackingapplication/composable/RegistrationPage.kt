package com.example.budgettrackingapplication.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.R
import com.example.budgettrackingapplication.ui.theme.BudgetTrackingApplicationTheme
import com.example.budgettrackingapplication.ui.theme.montserrat
import androidx.compose.ui.tooling.preview.Preview as Preview1


@Composable
fun RegistrationPage(navHostController: NavHostController){

    val email = remember { mutableStateOf("") }

    val isEmailValid = remember { mutableStateOf(false) }

    val registrationerror = remember { mutableStateOf("") }

    val password = remember { mutableStateOf("") }

    val viewpassword = remember { mutableStateOf(false) }
    
    val termsChecked = remember { mutableStateOf(false) }

    BackgroundDesign()

//    val focusRequester = remember { FocusRequester() }


    Column (
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Text(
            text = "Create Account".uppercase(),
            style = TextStyle(
                fontSize = 60.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0XFFFFFFFF),
            ),
            modifier = Modifier
                .padding(top = 100.dp)
        )

        Spacer(
            modifier = Modifier.padding(10.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
//                .clip(RoundedCornerShape(
//                    topStart = 30.dp,
//                    bottomEnd = 30.dp
//                )
//                )

        ) {

//Email Input
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                value = email.value,
                onValueChange = { email.value = it },
                label = {
                    Text(
                        text = "Email Address",
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
                modifier = Modifier.padding(5.dp)
            )

//Password Input
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                trailingIcon = {
                    IconButton(onClick = {
                        viewpassword.value = !viewpassword.value
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.password_eye),
                            contentDescription = null)
                    }
                },
                label = {
                    Text(
                        text = "Password",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            letterSpacing = .24.sp
                        )
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
                singleLine = true,
                visualTransformation = if (viewpassword.value)
                {
                    VisualTransformation.None
                }
                else
                {
                    PasswordVisualTransformation()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .alpha(1f)
            )

            Spacer(
                modifier = Modifier.padding(10.dp)
            )

            Row (
                verticalAlignment = Alignment.Top,
//                horizontalArrangement = Arrangement.SpaceBetween
            ) {
//Registration Errors
            Text(
                    text = registrationerror.value,
                    style = TextStyle(
                        color = Color.Red,
                        fontFamily = montserrat,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    ),
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .fillMaxWidth(),
                )
            }

//Checkbox for Terms and Conditions
            Spacer(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = termsChecked.value,
                    onCheckedChange = { termsChecked.value = it},
                    colors = CheckboxDefaults.colors(Color.White)
                )

                ClickableText(text = buildAnnotatedString {
                    append("I have read ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                        )
                    ) {
                        append("Terms and Condition")
                    }
                    append(" and ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                        )
                    ) {
                        append("Privacy policy")
                    }
                },
                    onClick = {
                        termsChecked.value = true
                    },
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.2.sp,
                    )
                )
            }

            Spacer(
                modifier = Modifier.padding(10.dp)
            )

//Login Button
            Button(
                onClick = {
                    isEmailValid.value = isValidEmail(email.value)
                    if (email.value.isNotEmpty() && isEmailValid.value) {

                    }
                    else {
                        registrationerror.value = "Email is invalid"
                    }
                },
                enabled = email.value.isNotEmpty() && password.value.isNotEmpty() && termsChecked.value,
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

            Spacer(
                modifier = Modifier.padding(10.dp)
            )
//Create Account Button
            ClickableText(text = buildAnnotatedString {
                append("Already have and account? ")
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                    )
                ) {
                    append("Login")
                }
            },
                onClick = {
                    println("Clicked offset $it")
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                    letterSpacing = 0.2.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Spacer(
                modifier = Modifier.padding(5.dp)
            )

        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegistrationPagePreview(){
    RegistrationPage(rememberNavController())
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}