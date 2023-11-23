package com.example.budgettrackingapplication.composable.components.chartsui.line

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.LineChartData
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.LineChartData.Point
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.renderer.line.SolidLineDrawer
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.renderer.point.FilledCircularPointDrawer
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.renderer.point.HollowCircularPointDrawer
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.renderer.point.NoPointDrawer
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.renderer.point.PointDrawer
import com.example.budgettrackingapplication.composable.components.chartsui.line.LineChartDataModel.PointDrawerType.Filled
import com.example.budgettrackingapplication.composable.components.chartsui.line.LineChartDataModel.PointDrawerType.Hollow
import com.example.budgettrackingapplication.composable.components.chartsui.line.LineChartDataModel.PointDrawerType.None

class LineChartDataModel {
  var lineChartData by mutableStateOf(
    LineChartData(
      points = listOf(
        Point(randomYValue(), "Label1"),
        Point(randomYValue(), "Label2"),
        Point(randomYValue(), "Label3"),
        Point(randomYValue(), "Label4"),
        Point(randomYValue(), "Label5"),
        Point(randomYValue(), "Label6"),
        Point(randomYValue(), "Label7")
      ),
        lineDrawer = SolidLineDrawer(),
    )
  )

  var lineChartData2 by mutableStateOf(
    LineChartData(
      points = listOf(
        Point(randomYValue(), "Label1"),
        Point(randomYValue(), "Label2"),
        Point(randomYValue(), "Label3"),

      ),
      lineDrawer = SolidLineDrawer(
        color = Color(0xFF00FF00)
      )
    )
  )
  var horizontalOffset by mutableStateOf(5f)
  var pointDrawerType by mutableStateOf(Filled)
  val pointDrawer: PointDrawer
    get() {
      return when (pointDrawerType) {
        None -> NoPointDrawer
        Filled -> FilledCircularPointDrawer()
        Hollow -> HollowCircularPointDrawer()
      }
    }

  private fun randomYValue(): Float = (100f * Math.random()).toFloat() + 45f

  enum class PointDrawerType {
    None,
    Filled,
    Hollow
  }
}