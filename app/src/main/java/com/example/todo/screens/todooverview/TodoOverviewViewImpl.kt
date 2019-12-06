package com.example.todo.screens.todooverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.screens.common.BaseObservableViewImpl
import com.example.todo.screens.todooverview.todoitem.TodoItem
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class TodoOverviewViewImpl(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : BaseObservableViewImpl<TodoOverviewView.Listener>(),
    TodoOverviewView, View.OnClickListener {

    private val addTodoEditText: EditText
    private val addTodoButton: Button
    private val todoList: RecyclerView
    private val adapter: FastAdapter<TodoItem>
    private val itemAdapter: ItemAdapter<TodoItem>


    init {
        rootView = layoutInflater.inflate(
            R.layout.activity_main,
            parent,
            false
        )
        addTodoEditText = findViewById(R.id.create_todo_input)
        addTodoButton = findViewById(R.id.create_todo_button)
        addTodoButton.setOnClickListener(this)
        itemAdapter = ItemAdapter<TodoItem>()
        adapter = FastAdapter.with(itemAdapter)
        todoList = findViewById(R.id.todo_list)
        todoList.adapter = adapter

//        todoList.onItemClickListener =
//            AdapterView.OnItemClickListener { _, _, position, _ ->
//                Toast.makeText(getContext(), adapter.getItem(position), Toast.LENGTH_LONG)
//                    .show()
//            }
    }

    override fun setTodos(todos: List<TodoItem>) {
        itemAdapter.clear()
        itemAdapter.add(todos)
    }

    override fun onClick(v: View?) {
        notifyAllListeners {
            it.onAddTodo(addTodoEditText.text.toString())
        }
    }
}