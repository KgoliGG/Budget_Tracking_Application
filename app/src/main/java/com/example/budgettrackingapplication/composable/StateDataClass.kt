package com.example.budgettrackingapplication.composable

import androidx.compose.ui.graphics.Color
import com.example.budgettrackingapplication.composable.components.models.Category
import com.example.budgettrackingapplication.composable.components.models.Expense
import com.example.budgettrackingapplication.composable.components.models.Recurrence
import io.realm.kotlin.query.RealmResults
import java.time.LocalDate
import java.time.LocalDateTime

data class AddScreenState(
    val amount: String = "",
    val recurrence: Recurrence = Recurrence.None,
    val date: LocalDate = LocalDate.now(),
    val note: String = "",
    val category: Category? = null,
    val categories: RealmResults<Category>? = null
)

data class CategoriesState(
    val newCategoryColor: Color = Color.White,
    val newCategoryName: String = "",
    val colorPickerShowing: Boolean = false,
    val categories: List<Category> = listOf()
)

data class ExpensesState(
    val recurrence: Recurrence = Recurrence.Daily,
    val sumTotal: Double = 1250.98,
    val expenses: List<Expense> = listOf()
)

data class State(
    val expenses: List<Expense> = listOf(),
    val dateStart: LocalDateTime = LocalDateTime.now(),
    val dateEnd: LocalDateTime = LocalDateTime.now(),
    val avgPerDay: Double = 0.0,
    val totalInRange: Double = 0.0
)

data class ReportsState(
    val recurrence: Recurrence = Recurrence.Weekly,
    val recurrenceMenuOpened: Boolean = false
)