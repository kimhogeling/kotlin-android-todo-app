package com.example.todo.screens.todooverview

import com.example.todo.GetTodoUseCase
import com.example.todo.screens.todooverview.todoitem.TodoItem

class TodoOverviewController(private val getTodoUseCase: GetTodoUseCase) :
    TodoOverviewView.Listener {
    lateinit var todoOverviewView: TodoOverviewView

    private val todoList = mutableListOf<TodoItem>()

    override fun onAddTodo(todo: String) {
//        TODO use Mapper instead of TodoItem Constructor
        todoList.add(TodoItem(todo))
        todoOverviewView.setTodos(todoList.toList())
    }

    fun onCreate() {
        todoOverviewView.registerListener(this)
        todoList.addAll(getTodoUseCase.getTodos())
        todoOverviewView.setTodos(todoList.toList())
    }

    fun onDestroy() {
        todoOverviewView.unregisterListener(this)
    }
}