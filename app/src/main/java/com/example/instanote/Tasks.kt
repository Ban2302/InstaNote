package com.example.instanote

import java.io.FileDescriptor

data class Tasks(
    val id: Int,
    val description: String,
    var isCompleted: Boolean = false
)