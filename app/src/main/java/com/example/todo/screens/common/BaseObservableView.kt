package com.example.todo.screens.common

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes

interface BaseObservableView<T> {
    var rootView: View
    fun <T : View> findViewById(@IdRes id: Int): T
    fun getString(@StringRes id: Int): String
    fun registerListener(listener: T)
    fun unregisterListener(listener: T)
}