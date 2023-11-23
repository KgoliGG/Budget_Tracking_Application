package com.example.budgettrackingapplication.composable.components.models

import androidx.compose.ui.graphics.Color
import io.realm.kotlin.types.RealmObject

class Category() : RealmObject {
    @io.realm.kotlin.types.annotations.PrimaryKey
    var _id: io.realm.kotlin.types.ObjectId = io.realm.kotlin.types.ObjectId.create()

    private var _colorValue: String = "0,0,0"
    var name: String = ""
    val color: Color
        get() {
            val colorComponents = _colorValue.split(",")
            val (red, green, blue) = colorComponents
            return Color(red.toFloat(), green.toFloat(), blue.toFloat())
        }

    constructor(
        name: String,
        color: Color
    ) : this() {
        this.name = name
        this._colorValue = "${color.red},${color.green},${color.blue}"
    }
}