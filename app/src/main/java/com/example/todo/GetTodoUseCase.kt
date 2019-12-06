package com.example.todo

import com.example.todo.screens.todooverview.todoitem.TodoItem

open class GetTodoUseCase {
    open fun getTodos(): List<TodoItem> {
        return listOf(
            TodoItem("Todo 1"),
            TodoItem("Todo 2")
        )
    }
}