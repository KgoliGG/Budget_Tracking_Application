package com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.renderer.line

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

interface LineDrawer {
  fun drawLine(
    drawScope: DrawScope,
    canvas: Canvas,
    linePath: Path
  )
}