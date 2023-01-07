package com.example.studenthardlife

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.studenthardlife.databinding.DetailBinding
import com.example.studenthardlife.databinding.DialogUpdateBinding

class Detail : Fragment() {

    private lateinit var itemId: String
    private lateinit var dbHandler: DBHandler
    private lateinit var item: Task

    val binding by lazy { DetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { itemId = it.getString("itemId").toString() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = this.context
        if (context != null) {
            dbHandler = DBHandler(context)

            item = dbHandler.getTask().find { item -> item.id.toString() == itemId }!!
            binding.textViewDetailSubject.text = item.subject
            binding.textViewDetailTask.text = item.task

            binding.buttonDetailDelete.setOnClickListener {
                dbHandler.deleteTask(item)
                Navigation.findNavController(binding.root).navigate(R.id.action_detail_to_list)
            }

            binding.buttonDetailEdit.setOnClickListener {
                setupDialog(item)
            }

            binding.buttonDetailBack.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.action_detail_to_list)
            }
        }

        return binding.root
    }

    private fun setupDialog(item : Task) {
        val context = this.context
        if (context != null) {
            val dialog = Dialog(context)
            val dialogBinding = DialogUpdateBinding.inflate(LayoutInflater.from(context))
            dialog.apply {
                setCancelable(false)
                setContentView(dialogBinding.root)
            }

            dialogBinding.apply {
                editTextSubjectUpdate.setText(item.subject.toString())
                editTextTaskUpdate.setText(item.task.toString())

                buttonUpdate.setOnClickListener {
                    updateDialog(dialogBinding, item, dialog)
                }

                buttonCancel.setOnClickListener { dialog.dismiss() }
            }
            dialog.show()
        }
    }

    private fun updateDialog(dialogBinding: DialogUpdateBinding, item: Task, dialog: Dialog) {

        val updateSubject = dialogBinding.editTextSubjectUpdate.text.toString()
        val updateText = dialogBinding.editTextTaskUpdate.text.toString()

        if (updateSubject.isNotEmpty() && updateText.isNotEmpty()) {
            dbHandler.updateTask(item.id, item.subject, item.task)
            dialog.dismiss()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}