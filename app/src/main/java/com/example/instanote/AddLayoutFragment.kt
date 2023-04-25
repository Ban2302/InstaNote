package com.example.instanote

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instanote.databinding.AddLayoutBinding
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class AddLayoutFragment : Fragment() {

    private lateinit var binding: AddLayoutBinding
    private val tasks = mutableListOf<Tasks>()
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var firestore: FirebaseFirestore


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

        firestore = FirebaseFirestore.getInstance()
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
                    saveTask(newTask)
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .create()

        dialog.show()
    }
    fun saveTask (task: Tasks) {
        val taskData = hashMapOf("id" to task.id, "description" to task.description)

        firestore.collection("tasks").add(taskData)
            .addOnSuccessListener { documentReference: DocumentReference ->
                Log.d(TAG, "Task added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e: Exception ->
                Log.w(TAG, "Error while uploading the task", e)
            }
    }
}