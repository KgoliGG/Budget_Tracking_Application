package com.example.budgettrackingapplication.composable.components.charts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.BarChart
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.BarChartData
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.yaxis.SimpleYAxisDrawer
import com.example.budgettrackingapplication.composable.components.models.Expense
import com.example.budgettrackingapplication.composable.components.models.Recurrence
import com.example.budgettrackingapplication.composable.components.models.groupedByMonth
import com.example.budgettrackingapplication.composable.components.utils.simplifyNumber
import com.example.budgettrackingapplication.composable.ui.theme.LabelSecondary
import java.time.Month

@Composable
fun YearlyChart(expenses: List<Expense>) {
    val groupedExpenses = expenses.groupedByMonth()

    BarChart(
        barChartData = BarChartData(
            bars = listOf(
                BarChartData.Bar(
                    label = Month.JANUARY.name.substring(0, 1),
                    value = groupedExpenses[Month.JANUARY.name]?.total?.toFloat()
                        ?: 0f,
                    color = Color.White,
                ),
                BarChartData.Bar(
                    label = Month.FEBRUARY.name.substring(0, 1),
                    value = groupedExpenses[Month.FEBRUARY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.MARCH.name.substring(0, 1),
                    value = groupedExpenses[Month.MARCH.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.APRIL.name.substring(0, 1),
                    value = groupedExpenses[Month.APRIL.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.MAY.name.substring(0, 1),
                    value = groupedExpenses[Month.MAY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.JUNE.name.substring(0, 1),
                    value = groupedExpenses[Month.JUNE.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.JULY.name.substring(0, 1),
                    value = groupedExpenses[Month.JULY.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.AUGUST.name.substring(0, 1),
                    value = groupedExpenses[Month.AUGUST.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.SEPTEMBER.name.substring(0, 1),
                    value = groupedExpenses[Month.SEPTEMBER.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.OCTOBER.name.substring(0, 1),
                    value = groupedExpenses[Month.OCTOBER.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.NOVEMBER.name.substring(0, 1),
                    value = groupedExpenses[Month.NOVEMBER.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
                BarChartData.Bar(
                    label = Month.DECEMBER.name.substring(0, 1),
                    value = groupedExpenses[Month.DECEMBER.name]?.total?.toFloat() ?: 0f,
                    color = Color.White
                ),
            )
        ),
        labelDrawer = LabelDrawer(recurrence = Recurrence.Yearly),
        yAxisDrawer = SimpleYAxisDrawer(
            labelTextColor = LabelSecondary,
            labelValueFormatter = ::simplifyNumber,
            labelRatio = 7,
            labelTextSize = 14.sp
        ),
        barDrawer = BarDrawer(recurrence = Recurrence.Yearly),
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxSize()
    )
}