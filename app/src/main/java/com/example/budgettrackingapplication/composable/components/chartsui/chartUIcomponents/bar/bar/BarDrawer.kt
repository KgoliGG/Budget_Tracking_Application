package com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.bar

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.BarChartData

interface BarDrawer {
  fun drawBar(
    drawScope: DrawScope,
    canvas: Canvas,
    barArea: Rect,
    bar: BarChartData.Bar
  )
}