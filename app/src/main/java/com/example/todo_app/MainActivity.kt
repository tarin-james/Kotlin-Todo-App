package com.example.todo_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        val todoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        val addTodos = findViewById<Button>(R.id.btnAddTodo)
        val todoTextField = findViewById<EditText>(R.id.etTodoTitle)
        val btnDeleteDoneTodo = findViewById<Button>(R.id.btnDeleteDoneTodo)

        todoItems.adapter = todoAdapter
        todoItems.layoutManager = LinearLayoutManager(this)

        addTodos.setOnClickListener {
            val todoTitle = todoTextField.text.toString()
                if(todoTitle.isNotEmpty()) {
                    val todo = Todo(todoTitle)
                    todoAdapter.addTodo(todo)
                    todoTextField.text.clear()
                }

        }
        btnDeleteDoneTodo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}