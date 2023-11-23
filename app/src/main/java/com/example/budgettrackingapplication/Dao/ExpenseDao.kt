package com.example.budgettrackingapplication.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.budgettrackingapplication.composable.components.models.Expense

@Dao

interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: com.example.budgettrackingapplication.composable.Expense)

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses(): List<Expense>
}
