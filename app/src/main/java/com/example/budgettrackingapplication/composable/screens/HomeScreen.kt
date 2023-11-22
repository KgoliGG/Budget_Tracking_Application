package com.example.budgettrackingapplication.composable.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.budgettrackingapplication.composable.BackgroundDesign
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import java.time.format.TextStyle

data class Expense(val category: String, val amount: Float)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    var income by remember { mutableStateOf(0f) }
    var expenses by remember { mutableStateOf(emptyList<Expense>()) }
    var category by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    BackgroundDesign()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Expense Tracker") })
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Income input
                OutlinedTextField(
                    value = income.toString(),
                    onValueChange = { income = it.toFloatOrNull() ?: 0f },
                    label = { Text("Income") }
                )

                // Expense input
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = category,
                        onValueChange = { category = it },
                        label = { Text("Category") }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    OutlinedTextField(
                        value = amount,
                        onValueChange = { amount = it },
                        label = { Text("Amount") }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            val expense = Expense(category, amount.toFloatOrNull() ?: 0f)
                            expenses = expenses + expense
                            category = ""
                            amount = ""
                        }
                    ) {
                        Text("Add Expense")
                    }
                }

                // Expense list
                LazyColumn {
                    items(expenses) { expense ->
                        Text(text = "${expense.category}: $${expense.amount}")
                    }
                }

                // Graph
                Graph(expenses)
            }
        }
    )

}


val customTypography = Typography(
    androidx.compose.ui.text.TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
)

@Composable
fun Graph(expenses: List<Expense>) {
    var totalExpenses = 0f
    var maxExpense = 0f

    for (expense in expenses) {
        totalExpenses += expense.amount
        if (expense.amount > maxExpense) {
            maxExpense = expense.amount
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Expenses Graph", style = customTypography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray)
                .padding(4.dp)
        ) {
            expenses.forEach { expense ->
                val width = (expense.amount / maxExpense) * 100
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width.dp)
                        .background(Color.Blue)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Total Expenses: $${totalExpenses}")
    }
}

@Preview
@Composable
fun previewHomeScreeen(){
    BackgroundDesign()
    HomeScreen(rememberNavController())
}