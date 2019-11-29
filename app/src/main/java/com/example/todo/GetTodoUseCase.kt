package com.example.todo

open class GetTodoUseCase {
    open fun getTodos(): List<String> {
        return listOf("todo 1", "todo 2")
    }
}