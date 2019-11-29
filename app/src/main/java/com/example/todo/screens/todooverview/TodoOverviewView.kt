package com.example.todo.screens.todooverview

import com.example.todo.screens.common.BaseObservableView

interface TodoOverviewView : BaseObservableView<TodoOverviewView.Listener> {
    fun setTodos(todos: List<String>)

    interface Listener {
        fun onAddTodo(todo: String)
    }
}