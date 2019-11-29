package com.example.todo.screens.todooverview

import android.util.Log
import com.example.todo.GetTodoUseCase

class TodoOverviewController(private val getTodoUseCase: GetTodoUseCase) :
    TodoOverviewView.Listener {
    lateinit var todoOverviewView: TodoOverviewView

    private val todoList = mutableListOf<String>()

    override fun onAddTodo(todo: String) {
        todoList.add(todo)
        Log.i("onAddTodo", todoList.toString())
        todoOverviewView.setTodos(todoList.toList())
    }

    fun onCreate() {
        todoOverviewView.registerListener(this)
        todoList.addAll(getTodoUseCase.getTodos())
        Log.i("onCreate", todoList.toString())
        todoOverviewView.setTodos(todoList.toList())
    }

    fun onDestroy() {
        todoOverviewView.unregisterListener(this)
    }
}