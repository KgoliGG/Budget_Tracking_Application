package com.example.budgettrackingapplication.composable

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.budgettrackingapplication.composable.components.models.Recurrence
import java.time.LocalDate

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "recurrence") val recurrence: Recurrence,
    @ColumnInfo(name = "date") val date: LocalDate,
    @ColumnInfo(name = "note") val note: String,
    @ColumnInfo(name = "category_name") val categoryName: String,
    @ColumnInfo(name = "category_color") val categoryColor: Int
)
