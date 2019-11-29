package com.example.todo.screens.todooverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.CompositionRoot

class MainActivity : AppCompatActivity() {
    private lateinit var compositionRoot: CompositionRoot

    private lateinit var todoOverviewController: TodoOverviewController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        compositionRoot = CompositionRoot(this)

        val todoOverviewView = compositionRoot.getTodoOverviewView(null)
        setContentView(todoOverviewView.rootView)

        todoOverviewController = compositionRoot.getTodoOverviewController()
        todoOverviewController.todoOverviewView = todoOverviewView

        todoOverviewController.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()

        todoOverviewController.onDestroy()
    }
}
