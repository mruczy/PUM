package com.example.studenthardlife

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.studenthardlife.databinding.ListBinding


import android.view.View
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import com.example.studenthardlife.databinding.ItemBinding

class TaskAdapter(private val dbHandler: DBHandler, private val context: Context) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Task) {
            itemBinding.textViewId.text = item.id.toString()
            itemBinding.textViewSubject.text = item.subject
            itemBinding.textViewTask.text = item.task

            itemBinding.imageViewEdit.setOnClickListener {
                val action = ListDirections.actionListToDetail(itemId = item.id.toString())
                Navigation.findNavController(itemView).navigate(action)
            }

            itemBinding.imageViewDelete.setOnClickListener {
                dbHandler.deleteTask(item)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemBinding = ItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dbHandler.getTask()[position]
        holder.bind(item)
    }
    override fun getItemCount() = dbHandler.getTask().size
}
