package com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.line.renderer.line

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

object NoLineShader : LineShader {
    override fun fillLine(drawScope: DrawScope, canvas: Canvas, fillPath: Path) {
        // Do nothing
    }
}
