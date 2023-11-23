package com.example.budgettrackingapplication.composable.components.viewmodels

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgettrackingapplication.composable.CategoriesState
import com.example.budgettrackingapplication.composable.components.models.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CategoriesState())
    val uiState: StateFlow<CategoriesState> = _uiState.asStateFlow()

    private lateinit var categoryDao: CategoryDao

    fun initializeDatabase(context: Context) {
        val database = AppDatabase.getInstance(context)
        categoryDao = database.categoryDao()

        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { currentState ->
                currentState.copy(
                    categories = categoryDao.getAllCategories()
                )
            }
        }
    }

    fun setNewCategoryColor(color: Color) {
        _uiState.update { currentState ->
            currentState.copy(
                newCategoryColor = color
            )
        }
    }

    fun setNewCategoryName(name: String) {
        _uiState.update { currentState ->
            currentState.copy(
                newCategoryName = name
            )
        }
    }

    fun showColorPicker() {
        _uiState.update { currentState ->
            currentState.copy(
                colorPickerShowing = true
            )
        }
    }

    fun hideColorPicker() {
        _uiState.update { currentState ->
            currentState.copy(
                colorPickerShowing = false
            )
        }
    }

    fun createNewCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            categoryDao.insertCategory(
                Category(
                    name = _uiState.value.newCategoryName,
                    color = _uiState.value.newCategoryColor
                )
            )
            _uiState.update { currentState ->
                currentState.copy(
                    newCategoryColor = Color.White,
                    newCategoryName = ""
                )
            }
        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            categoryDao.deleteCategory(category)
        }
    }
}