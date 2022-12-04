package com.example.crime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class List : Fragment() {

    private val crimeList = listOf(
        Crime("1", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("2", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("3", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("4", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("5", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("6", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("7", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("8", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("9", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("10", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("11", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("12", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("13", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("14", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("15", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("16", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("17", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("18", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("19", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
        Crime("20", "description description description description", Random.nextInt(100000, 900000).toString(), Random.nextBoolean()),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CrimeAdapter(crimeList)
    }
}