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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettrackingapplication.R
import com.example.budgettrackingapplication.ui.theme.BudgetTrackingApplicationTheme
import com.example.budgettrackingapplication.ui.theme.montserrat

@ExperimentalMaterial3Api
class LoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(){
            BudgetTrackingApplicationTheme{
//                val navController: NavController
//                navController = rememberNavController()
                LoginPagePreview()
            }
        }
    }

}

@ExperimentalMaterial3Api
@Composable
fun LoginPageLayout(){

    val email = remember { mutableStateOf("") }

    val loginerror = "Email Error"

    val password = remember { mutableStateOf("") }

    val viewpassword = remember { mutableStateOf(false) }

//    val focusRequester = remember { FocusRequester() }


    Column (
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Text(
            text = "Login".uppercase(),
            style = TextStyle(
                fontSize = 50.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(700),
                color = Color(0XFFFFFFFF),
            ),
            modifier = Modifier
                .padding(top = 150.dp)
        )

        Text(
            text = "with your account registered with Savio to continue with the app.",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.24.sp,
            ),
            modifier = Modifier
                .padding(top = 10.dp)
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
                            fontSize = 14.sp,
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
                            fontSize = 14.sp,
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
            ){
                //Login Errors
                Text(

                    text = loginerror,
                    style = TextStyle(
                        color = Color.Red,
                        fontFamily = montserrat,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    ),
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .fillMaxWidth(.6f),
                )

                Spacer(
                    modifier = Modifier.padding(10.dp)
                )
//Forgot Password
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(
                        fontSize = 12.sp,
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


//Checkbox for Terms and Conditions
            Spacer(
                modifier = Modifier.padding(40.dp)
            )

            val checked = remember {
                mutableStateOf(false)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = checked.value,
                    onCheckedChange = { checked.value = it},
                    colors = CheckboxDefaults.colors(Color.White)
                )

                Text(
                    text = "I agree to all the Terms & Conditions.",
                    style = TextStyle(
                        fontSize = 12.sp,
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

//Create Account Button
            OutlinedButton(
                onClick = { /*TODO*/ },
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
                onClick = { /*TODO*/ },
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

@ExperimentalMaterial3Api
@Preview
@Composable
fun LoginPagePreview(){
    BackgroundDesign()
    LoginPageLayout()
}