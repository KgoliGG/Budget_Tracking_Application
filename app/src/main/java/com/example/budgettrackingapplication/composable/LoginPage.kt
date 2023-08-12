package com.example.budgettrackingapplication.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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

    val email = remember {
        mutableStateOf("")
    }

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
                fontSize = 42.sp,
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
//                .clip(RoundedCornerShape(
//                    topStart = 30.dp,
//                    bottomEnd = 30.dp
//                )
//                )

        ) {
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = {
                    Text(
                        text = "Email Address",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            letterSpacing = .24.sp
                        )
                    )
                },
                placeholder = {
                    Text(
                        text = "Email Address",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(400),
                            letterSpacing = .24.sp
                        )
                    )

                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

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
                            fontSize = 12.sp,
                            letterSpacing = .24.sp
                        )
                    )
                },
                placeholder = {
                    Text(
                        text = "Password",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = montserrat,
                            fontWeight = FontWeight(400),
                            letterSpacing = .24.sp
                        )
                    )

                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .alpha(1f)
            )



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