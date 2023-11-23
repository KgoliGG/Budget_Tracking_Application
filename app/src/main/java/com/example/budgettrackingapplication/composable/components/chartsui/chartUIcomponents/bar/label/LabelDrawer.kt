package com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.label

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

interface LabelDrawer {
  fun requiredXAxisHeight(drawScope: DrawScope): Float = 0f
  fun requiredAboveBarHeight(drawScope: DrawScope): Float = 0f

  fun drawLabel(
    drawScope: DrawScope,
    canvas: Canvas,
    label: String,
    barArea: Rect,
    xAxisArea: Rect
  )
}