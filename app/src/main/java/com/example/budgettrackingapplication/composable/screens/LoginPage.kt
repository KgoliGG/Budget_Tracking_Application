package com.example.budgettrackingapplication.composable.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.budgettrackingapplication.R
import com.example.budgettrackingapplication.composable.BackgroundDesign
import com.example.budgettrackingapplication.composable.DatabaseHelper
import com.example.budgettrackingapplication.composable.LoginUser
import com.example.budgettrackingapplication.composable.components.CheckboxComponentes
import com.example.budgettrackingapplication.composable.components.ErrorMessage
import com.example.budgettrackingapplication.composable.components.HeadingText
import com.example.budgettrackingapplication.composable.components.SubHeading
import com.example.budgettrackingapplication.navigation.Screen
import com.example.budgettrackingapplication.ui.theme.montserrat


@Composable
fun LoginPage(navController: NavController){

    Surface (
         modifier = Modifier
             .fillMaxSize()
    ) {
        BackgroundDesign()

        val email = remember { mutableStateOf("") }

        val loginerror = remember { mutableStateOf("") }

        val password = remember { mutableStateOf("") }

        val viewpassword = remember { mutableStateOf(false) }

        var isEmailValid by remember { mutableStateOf(true) }

        var isPasswordValid by remember { mutableStateOf(true) }

        val context = LocalContext.current

        val databaseHelper = DatabaseHelper(context)

//    val focusRequester = remember { FocusRequester() }


        Column (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 100.dp, end = 20.dp, bottom = 50.dp)
        ){
            HeadingText(
                value = "Login",
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 80.sp
                )
            )

            SubHeading(value = "with your account registered with SOLVIO to continue with the app.")

            Spacer(
                modifier = Modifier
                    .padding(10.dp)
            )

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()

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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .fillMaxWidth()
                ){
//Login Errors
                    ErrorMessage(value = loginerror.value)

                    Spacer(
                        modifier = Modifier.padding(10.dp)
                    )
//Forgot Password
                    Text(
                        text = "Forgot Password?",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.2.sp,
                        ),
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.End,
                    )
                }

                val checked = remember {
                    mutableStateOf(true)
                }


//Checkbox for Terms and Conditions
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.2f)
                )

                CheckboxComponentes(onSelectedText = {
                    if(it == ("Terms of Use")){
                        navController.navigate(
                            route = Screen.TermsAndCondition.name
                        )
                    }
                    else if(it == ("Privacy Policies")){
                        navController.navigate(
                            route = Screen.PrivacyPolicies.name
                        )
                    }
                    else{
                        checked.value = true
                    }
                })

//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Start,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 50.dp)
//                ) {
//                    Checkbox(
//                        checked = checked.value,
//                        onCheckedChange = { checked.value = it},
//                        colors = CheckboxDefaults.colors(Color.White)
//                    )
//
//                    ClickableText(text = buildAnnotatedString {
//                        append(
//                            text = "I have read all ",
//                        )
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.White,
//                            )
//                        ) {
//                            append("Terms and Condition")
//                        }
//                    },
//                        onClick = {
//                            checked.value = true
//                        },
//                        style = TextStyle(
//                            fontSize = 14.sp,
//                            fontFamily = montserrat,
//                            fontWeight = FontWeight(600),
//                            color = Color(0xFFFFFFFF),
//                            letterSpacing = 0.2.sp,
//                        )
//                    )
//                }

                Spacer(
                    modifier = Modifier.padding(10.dp)
                )

//Create Account Button
                OutlinedButton(
                    onClick = {
                        navController.navigate(
                            route = Screen.RegistrationPage.name
                        )
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = "Create Account",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.2.sp,
                        )
                    )

                }

                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
//Login Button
                Button(
                    onClick = {
                        val emailValue = email.value
                        val passwordValue = password.value
                        val user = LoginUser(emailValue, passwordValue)

                        isEmailValid = validateEmail(emailValue)
                        isPasswordValid = validatePassword(passwordValue)

                        if (!isEmailValid){
                            loginerror.value = "Invalid Email"
                        }
                        else if (!isPasswordValid){
                            loginerror.value = "Password should be at least 6 characters"
                        }
                        else{
                            val userExists = databaseHelper.checkCredentials(user)
                            if (userExists){
                                navController.navigate(
                                    route = Screen.UserSetup.name
                                )
                            }
                            else{
                                loginerror.value = "User doesn't exist"
                            }
                        }

                    },
                    enabled = email.value.isNotEmpty() && password.value.isNotEmpty() && checked.value,
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
                        text = "Login".uppercase(),
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
}

@Preview
@Composable
fun LoginPagePreview(){
    BackgroundDesign()
    LoginPage(rememberNavController())
}

private fun validateEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

private fun validatePassword(password: String): Boolean {
    return password.length >= 6
}