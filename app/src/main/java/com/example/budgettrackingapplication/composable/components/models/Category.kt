package com.example.budgettrackingapplication.composable.components.models

import androidx.compose.ui.graphics.Color
import androidx.room.PrimaryKey
import io.realm.kotlin.types.RealmObject
import org.mongodb.kbson.ObjectId

class Category() : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke()

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