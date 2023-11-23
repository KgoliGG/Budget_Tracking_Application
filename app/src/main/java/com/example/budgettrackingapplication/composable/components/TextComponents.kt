package com.example.budgettrackingapplication.composable.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettrackingapplication.ui.theme.montserrat

@Composable
fun HeadingText(value: String){
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

//@Composable
//fun CheckboxComponentes (navController: NavController) {
//
//    val checkedState = remember {
//        mutableStateOf(false)
//    }
//
//
//
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Start,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 50.dp)
//    ) {
//        Checkbox(
//            checked = checkedState.value,
//            onCheckedChange = { checkedState.value = it},
//            colors = CheckboxDefaults.colors(Color.White)
//        )
//
//        ClickableText(
//            text = buildAnnotatedString {
//            append(
//                text = "I have read all ",
//            )
//            withStyle(
//                style = SpanStyle(
//                    color = Color.White,
//                )
//            ) {
//                append("Terms and Condition")
//            }
//        },
//            onClick = {
//                checkedState.value = true
//            },
//            style = TextStyle(
//                fontSize = 14.sp,
//                fontFamily = montserrat,
//                fontWeight = FontWeight(600),
//                color = Color(0xFFFFFFFF),
//                letterSpacing = 0.2.sp,
//            )
//        )
//    }
//}

@Composable
fun CheckboxComponentes (
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onSelectedText: (String) -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
//        Log.d("Statechange", "{${checked}}")
//        Log.d("Statechanged", "{${onCheckedChange}}")
        ClickableTextComponent(
            onSelectedText = onSelectedText,
        )
    }
}


@Composable
fun ClickableTextComponent(onSelectedText : (String) -> Unit){
    val initialText = "I accept all the "
    val termsText = "Terms of Use"
    val and = " and "
    val policyText = "Privacy Policies"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(
            style = SpanStyle(
                color = Color.White,
                textDecoration = TextDecoration.Underline
            )
        ){
            pushStringAnnotation(tag = termsText, annotation = termsText)
            append(termsText)
        }
        append(and)
        withStyle(
            style = SpanStyle(
                color = Color.White,
                textDecoration = TextDecoration.Underline
            )
        ){
            pushStringAnnotation(tag = policyText, annotation = policyText)
            append(policyText)
        }
    }
    
    ClickableText(
        text = annotatedString,
        onClick = {
            offset ->
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also {
                    span ->
//                    Log.d("ClickableTextComponent","{$span}")
                    if (span.item == termsText){
                        onSelectedText(span.item)
                    }
                }
        },
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = montserrat,
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
            letterSpacing = 0.2.sp
        )
    )
}