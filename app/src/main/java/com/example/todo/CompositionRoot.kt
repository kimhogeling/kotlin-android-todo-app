package com.example.todo

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.todo.screens.todooverview.TodoOverviewController
import com.example.todo.screens.todooverview.TodoOverviewView
import com.example.todo.screens.todooverview.TodoOverviewViewImpl

class CompositionRoot(private val activity: Activity) {
    private fun createTodoListUseCase(): GetTodoUseCase {
        return GetTodoUseCase()
    }

    fun getTodoOverviewController(): TodoOverviewController {
        return TodoOverviewController(
            createTodoListUseCase()
        )
    }

    fun getTodoOverviewView(parent: ViewGroup?): TodoOverviewView {
        return TodoOverviewViewImpl(
            LayoutInflater.from(activity),
            parent
        )
    }
}

