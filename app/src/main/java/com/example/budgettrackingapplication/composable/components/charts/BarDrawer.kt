package com.example.budgettrackingapplication.composable.components.charts

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.BarChartData
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.bar.bar.BarDrawer
import com.example.budgettrackingapplication.composable.components.models.Recurrence
import com.example.budgettrackingapplication.composable.ui.theme.SystemGray04

class BarDrawer constructor(recurrence: Recurrence) :
    BarDrawer {
    private val barPaint = Paint().apply {
        this.isAntiAlias = true
    }

    private val rightOffset = when(recurrence) {
        Recurrence.Weekly -> 24f
        Recurrence.Monthly -> 6f
        Recurrence.Yearly -> 18f
        else -> 0f
    }

    override fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar
    ) {
        canvas.drawRoundRect(
            barArea.left,
            0f,
            barArea.right + rightOffset,
            barArea.bottom,
            16f,
            16f,
            barPaint.apply {
                color = SystemGray04
            },
        )
        canvas.drawRoundRect(
            barArea.left,
            barArea.top,
            barArea.right + rightOffset,
            barArea.bottom,
            16f,
            16f,
            barPaint.apply {
                color = bar.color
            },
        )
    }
}