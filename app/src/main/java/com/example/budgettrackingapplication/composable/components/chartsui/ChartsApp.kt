package com.example.budgettrackingapplication.composable.components.chartsui

import androidx.compose.animation.Crossfade

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.budgettrackingapplication.composable.components.chartsui.bar.BarChartScreen
import com.example.budgettrackingapplication.composable.components.chartsui.line.LineChartScreen
import com.example.budgettrackingapplication.composable.components.chartsui.pie.PieChartScreen
import com.example.budgettrackingapplication.composable.components.chartsui.selector.SelectChartScreen
import com.example.budgettrackingapplication.composable.ui.theme.BudgetTrackingApplicationTheme

@Composable
fun ChartsApp() {
  BudgetTrackingApplicationTheme {
    AppContent()
  }
}

@Composable
fun AppContent() {
  Crossfade(ChartScreenStatus.currentChart, label = "") { screen ->
    Surface(color = MaterialTheme.colorScheme.background) {
      when (screen) {
        ChartScreen.SelectChart -> SelectChartScreen()
        ChartScreen.Pie -> PieChartScreen()
        ChartScreen.Bar -> BarChartScreen()
        ChartScreen.Line -> LineChartScreen()
      }
    }
  }
}
