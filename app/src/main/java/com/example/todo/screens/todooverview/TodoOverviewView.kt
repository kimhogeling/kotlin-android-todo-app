package com.example.todo.screens.todooverview

import com.example.todo.screens.common.BaseObservableView
import com.example.todo.screens.todooverview.todoitem.TodoItem

interface TodoOverviewView : BaseObservableView<TodoOverviewView.Listener> {
    fun setTodos(todos: List<TodoItem>)

    interface Listener {
        fun onAddTodo(todo: String)
    }
}