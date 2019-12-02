package com.example.todo.screens.todooverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.CompositionRoot

class MainActivity : AppCompatActivity() {
    private val compositionRoot: CompositionRoot by lazy {
        CompositionRoot(this)
    }

    private val view: TodoOverviewView by lazy {
        compositionRoot.getTodoOverviewView(null)
    }

    private val controller: TodoOverviewController by lazy {
        compositionRoot.getTodoOverviewController().apply {
            this.todoOverviewView = view
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.rootView)

        controller.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()

        controller.onDestroy()
    }
}
