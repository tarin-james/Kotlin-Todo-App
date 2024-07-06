package com.example.todo_app

data class Todo (
    val title: String,
    var isChecked: Boolean = false
)