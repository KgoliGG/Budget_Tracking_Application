package com.example.budgettrackingapplication.composable.components.chartsui.selector

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.budgettrackingapplication.composable.components.chartsui.ChartScreen
import com.example.budgettrackingapplication.composable.components.chartsui.ChartScreenStatus
import com.example.budgettrackingapplication.ui.theme.Margins.horizontal
import com.example.budgettrackingapplication.ui.theme.Margins.vertical


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SelectChartScreen() {
  Scaffold(
    topBar = { TopAppBar(title = { Text(text = "Select Chart") }) }
  ) { SelectChartScreenContent() }
}

@Composable
private fun SelectChartScreenContent() {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    ChartRow(text = "Pie Chart", navigateTo = ChartScreen.Pie)
    ChartRow(text = "Bar Chart", navigateTo = ChartScreen.Bar)
    ChartRow(text = "Line Chart", navigateTo = ChartScreen.Line)
  }
}

@Composable
private fun ChartRow(
  text: String,
  navigateTo: ChartScreen
) {
  Row(modifier = Modifier.padding(horizontal = horizontal, vertical = vertical)) {
    TextButton(
      onClick = { ChartScreenStatus.navigateTo(navigateTo) }
    ) {
      Text(text = text)
    }
  }
}

@Preview
@Composable
fun SelectChartScreenPreview() = SelectChartScreen()
