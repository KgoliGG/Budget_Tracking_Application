package com.example.budgettrackingapplication.composable.components.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgettrackingapplication.composable.AddScreenState
import com.example.budgettrackingapplication.composable.components.models.Category
import com.example.budgettrackingapplication.composable.components.models.Expense
import com.example.budgettrackingapplication.composable.components.models.Recurrence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

class AddViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AddScreenState())
    val uiState: StateFlow<AddScreenState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                categories = db.query<Category>().find()
            )
        }
    }

    fun setAmount(amount: String) {
        var parsed = amount.toDoubleOrNull()

        if (amount.isEmpty()) {
            parsed = 0.0
        }

        if (parsed != null) {
            _uiState.update { currentState ->
                currentState.copy(
                    amount = amount.trim().ifEmpty { "0" },
                )
            }
        }
    }

    fun setRecurrence(recurrence: Recurrence) {
        _uiState.update { currentState ->
            currentState.copy(
                recurrence = recurrence,
            )
        }
    }

    fun setDate(date: LocalDate) {
        _uiState.update { currentState ->
            currentState.copy(
                date = date,
            )
        }
    }

    fun setNote(note: String) {
        _uiState.update { currentState ->
            currentState.copy(
                note = note,
            )
        }
    }

    fun setCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                category = category,
            )
        }
    }

    fun submitExpense() {
        if (_uiState.value.category != null) {
            viewModelScope.launch(Dispatchers.IO) {
                val now = LocalDateTime.now()
                db.write {
                    this.copyToRealm(
                        Expense(
                            _uiState.value.amount.toDouble(),
                            _uiState.value.recurrence,
                            _uiState.value.date.atTime(now.hour, now.minute, now.second),
                            _uiState.value.note,
                            this.query<Category>("_id == $0", _uiState.value.category!!._id)
                                .find().first(),
                        )
                    )
                }
                _uiState.update { currentState ->
                    currentState.copy(
                        amount = "",
                        recurrence = Recurrence.None,
                        date = LocalDate.now(),
                        note = "",
                        category = null,
                        categories = null
                    )
                }
            }
        }
    }
}