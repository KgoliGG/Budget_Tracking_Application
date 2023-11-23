package com.example.budgettrackingapplication.composable.components.chartsui.pie

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettrackingapplication.composable.components.chartsui.ChartScreenStatus
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.pie.PieChart
import com.example.budgettrackingapplication.composable.components.chartsui.chartUIcomponents.pie.renderer.SimpleSliceDrawer
import com.example.budgettrackingapplication.ui.theme.Margins.horizontal
import com.example.budgettrackingapplication.ui.theme.Margins.vertical
import com.example.budgettrackingapplication.ui.theme.Margins.verticalLarge

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PieChartScreen() {
  Scaffold(
    topBar = {
      TopAppBar(
        navigationIcon = {
          IconButton(onClick = { ChartScreenStatus.navigateHome() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Go back to home")
          }
        },
        title = { Text(text = "Pie Chart") }
      )
    },
  ) { PieChartScreenContent() }
}

@Composable
private fun PieChartScreenContent() {
  val pieChartDataModel = remember { PieChartDataModel() }

  Column(
    modifier = Modifier.padding(
      horizontal = horizontal,
      vertical = vertical
    )
  ) {
    PieChartRow(pieChartDataModel)
    SliceThicknessRow(pieChartDataModel.sliceThickness) {
      pieChartDataModel.sliceThickness = it
    }
    AddOrRemoveSliceRow(pieChartDataModel)
  }
}

@Composable
private fun PieChartRow(pieChartDataModel: PieChartDataModel) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(150.dp)
      .padding(vertical = vertical)
  ) {
    PieChart(
      pieChartData = pieChartDataModel.pieChartData,
      sliceDrawer = SimpleSliceDrawer(
        sliceThickness = pieChartDataModel.sliceThickness
      )
    )
  }
}

@Composable
private fun SliceThicknessRow(sliceThickness: Float, onValueUpdated: (Float) -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = verticalLarge),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "Slice thickness",
      modifier = Modifier
        .align(Alignment.CenterVertically)
        .padding(end = horizontal)
    )
    Slider(
      value = sliceThickness,
      onValueChange = { onValueUpdated(it) },
      valueRange = 10f.rangeTo(100f)
    )
  }
}

@Composable
private fun AddOrRemoveSliceRow(pieChartDataModel: PieChartDataModel) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = vertical),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
  ) {
    Button(
      enabled = pieChartDataModel.slices.size > 3,
      onClick = { pieChartDataModel.removeSlice() },
      shape = CircleShape
    ) {
      Icon(Icons.Filled.Clear, contentDescription = "Remove slice from pie chart")
    }
    Row(
      modifier = Modifier.padding(horizontal = horizontal),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(text = "Slices: ")
      Text(
        text = pieChartDataModel.slices.count().toString(),
        style = TextStyle(
          fontWeight = FontWeight.ExtraBold,
          fontSize = 18.sp
        )
      )
    }
    Button(
      enabled = pieChartDataModel.slices.size < 9,
      onClick = { pieChartDataModel.addSlice() },
      shape = CircleShape
    ) {
      Icon(Icons.Filled.Add, contentDescription = "Add slice to pie chart")
    }
  }
}

@Preview
@Composable
fun PieChartScreenPreview() = PieChartScreen()