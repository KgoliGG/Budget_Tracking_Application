@file:Suppress("UNCHECKED_CAST")

package com.example.budgettrackingapplication.composable.components

import android.icu.util.ULocale.Category
import com.example.budgettrackingapplication.composable.Expense
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.BaseRealmObject
import kotlin.reflect.KClass

val config = RealmConfiguration.create(schema = setOf(Expense::class, Category::class) as Set<KClass<out BaseRealmObject>>)
val db: Realm = Realm.open(config)