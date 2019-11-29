package com.example.todo.screens.todooverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.todo.R
import com.example.todo.screens.common.BaseObservableViewImpl

class TodoOverviewViewImpl(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : BaseObservableViewImpl<TodoOverviewView.Listener>(),
    TodoOverviewView, View.OnClickListener {

    private val addTodoEditText: EditText
    private val addTodoButton: Button
    private val todoList: ListView
    private val adapter: ArrayAdapter<String>


    init {
        rootView = layoutInflater.inflate(
            R.layout.activity_main,
            parent,
            false
        )
        addTodoEditText = findViewById(R.id.create_todo_input)
        addTodoButton = findViewById(R.id.create_todo_button)
        addTodoButton.setOnClickListener(this)
        adapter = ArrayAdapter(getContext(), android.R.layout.simple_list_item_1)
        todoList = findViewById(R.id.todo_list)
        todoList.adapter = adapter

        todoList.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(getContext(), adapter.getItem(position), Toast.LENGTH_LONG)
                    .show()
            }
    }

    override fun setTodos(todos: List<String>) {
        adapter.clear()
        adapter.addAll(todos)
    }

    override fun onClick(v: View?) {
        notifyAllListeners {
            it.onAddTodo(addTodoEditText.text.toString())
        }
    }
}