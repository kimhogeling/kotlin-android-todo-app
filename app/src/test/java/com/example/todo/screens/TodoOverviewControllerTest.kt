package com.example.todo.screens

import com.example.todo.GetTodoUseCase
import com.example.todo.screens.todooverview.TodoOverviewController
import com.example.todo.screens.todooverview.TodoOverviewView
import com.nhaarman.mockitokotlin2.*
import org.junit.Before

import org.junit.Test

class TodoOverviewControllerTest {
    private lateinit var todoOverviewController: TodoOverviewController
    private lateinit var todoOverviewView: TodoOverviewView
    private lateinit var useCase: GetTodoUseCase

    @Before
    fun setUp() {
        useCase = mock {
            on { getTodos() } doReturn listOf("a", "b", "c")
        }
        todoOverviewController =
            TodoOverviewController(useCase)
        todoOverviewView = mock()
        todoOverviewController.todoOverviewView = todoOverviewView
    }

    @Test
    fun onCreateRegistersListenerOnView() {
        todoOverviewController.onCreate()

        verify(todoOverviewView).registerListener(todoOverviewController)
    }

    @Test
    fun onCreatePassesTodoListToView() {
        todoOverviewController.onCreate()

        verify(todoOverviewView).setTodos(listOf("a", "b", "c"))
    }

    @Test
    fun onDestroyUnregistersListenerOnView() {
        todoOverviewController.onDestroy()

        verify(todoOverviewView).unregisterListener(todoOverviewController)
    }

    @Test
    fun onAddTodoItemNotifiesView() {
        todoOverviewController.onCreate()

        argumentCaptor<TodoOverviewView.Listener>().apply {
            verify(todoOverviewView).registerListener(capture())

            firstValue.onAddTodo("hallo")

            verify(todoOverviewView).setTodos(listOf("a", "b", "c", "hallo"))
        }
    }
}