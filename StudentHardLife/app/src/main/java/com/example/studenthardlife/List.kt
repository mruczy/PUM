package com.example.studenthardlife

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studenthardlife.databinding.ListBinding

class List : Fragment() {

    private lateinit var dbHandler: DBHandler
    private val binding by lazy { ListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = this.context
        if (context != null) {
            dbHandler = DBHandler(context)
        }

        binding.dataBaseRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = TaskAdapter(dbHandler, this.context)
        }

        binding.addButton.setOnClickListener {
            val subject = binding.editTextSubject.text.toString()
            val task = binding.editTextTask.text.toString()

            if (subject.isNotEmpty() && task.isNotEmpty()) {
                dbHandler.addTask(Task(subject, task))
                binding.editTextSubject.text.clear()
                binding.editTextTask.text.clear()
            }

            binding.dataBaseRecyclerView.adapter?.notifyItemInserted(dbHandler.getTask().size)
        }
        return  binding.root
    }

    override fun onDestroy() {
        dbHandler.close()
        super.onDestroy()
    }
}