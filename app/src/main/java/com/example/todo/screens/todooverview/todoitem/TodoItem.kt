package com.example.todo.screens.todooverview.todoitem

import android.view.View
import android.widget.TextView
import com.example.todo.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

open class TodoItem(val text: String = "") : AbstractItem<TodoItem.ViewHolder>() {
    override val layoutRes: Int
        get() = R.layout.todo_list_item

    override val type: Int
        get() = R.id.todo_list_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<TodoItem>(view) {
        private val text: TextView = view.findViewById(R.id.todo_list_item_text_view)


        override fun bindView(item: TodoItem, payloads: MutableList<Any>) {
            text.text = item.text
        }

        override fun unbindView(item: TodoItem) {
            text.text = "";
        }

    }
}