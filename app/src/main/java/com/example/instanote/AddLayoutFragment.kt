package com.example.instanote

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instanote.databinding.AddLayoutBinding

class AddLayoutFragment : Fragment() {

    private lateinit var binding: AddLayoutBinding
    private val tasks = mutableListOf<Tasks>()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupAddTaskButton()
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(tasks)
        binding.rvAdd.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = taskAdapter
        }
    }


    private fun setupAddTaskButton() {
        binding.addTaskButton.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {
        val inputEditText = EditText(requireContext())
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Add Task")
            .setMessage("Enter task description")
            .setView(inputEditText)
            .setPositiveButton("Add") { _, _ ->
                val inputText = inputEditText.text.toString().trim()
                if (inputText.isEmpty()){
                    Toast.makeText(requireContext(), "Please write as description", Toast.LENGTH_LONG).show()
                } else {
                    val newTask = Tasks(id = tasks.size + 1, description = inputEditText.text.toString())
                    taskAdapter.addTask(newTask)
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .create()

        dialog.show()
    }
}