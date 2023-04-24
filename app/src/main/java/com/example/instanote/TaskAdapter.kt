package com.example.instanote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter (private val tasks: MutableList<Tasks>) :
        RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskCheckBox: CheckBox = itemView.findViewById(R.id.task_checkbox)
        private val taskDescription: TextView = itemView.findViewById(R.id.task_description)

        fun bind(task: Tasks) {
            taskDescription.text = task.description
            taskCheckBox.isChecked = task.isCompleted
            taskCheckBox.setOnCheckedChangeListener { _, isChecked ->
                task.isCompleted = isChecked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    fun addTask(task: Tasks) {
        tasks.add(task)
        notifyItemInserted(tasks.size -1)
    }
        }