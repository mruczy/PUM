package com.example.crime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class Detail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail, container, false)

        view.findViewById<Button>(R.id.detailReturn).setOnClickListener {
            val action = DetailDirections.toFragmentList()
            Navigation.findNavController(view).navigate(action)
        }

        view.findViewById<TextView>(R.id.detailTitle).text = arguments?.getString("detailTitle")
        view.findViewById<TextView>(R.id.detailIndex).text = arguments?.getString("detailIndex")
        view.findViewById<TextView>(R.id.detailContent).text = arguments?.getString("detailContent")
        view.findViewById<TextView>(R.id.detailSolved).text = arguments?.getString("detailSolved")

        return view
    }

}