package com.example.todo.screens.common

import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes

open class BaseObservableViewImpl<T> : BaseObservableView<T> {
    override lateinit var rootView: View
    private val listeners = mutableListOf<T>()

    override fun <T : View> findViewById(@IdRes id: Int): T {
        return rootView.findViewById(id)
    }

    override fun getString(@StringRes id: Int): String {
        return getContext().getString(id)
    }

    fun getContext(): Context {
        return rootView.context
    }

    override fun registerListener(listener: T) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: T) {
        listeners.remove(listener)
    }

    fun notifyAllListeners(action: (T) -> Unit) {
        listeners.forEach(action)
    }
}