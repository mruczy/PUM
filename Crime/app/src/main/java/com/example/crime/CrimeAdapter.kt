package com.example.crime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.List

class CrimeAdapter(private val crimesList: List<Crime>) : RecyclerView.Adapter<CrimeAdapter.CrimeListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.crime_item, parent, false)
        return CrimeListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CrimeListViewHolder, position: Int) {
        holder.title.text = crimesList[position].title
        holder.image.visibility = if (crimesList[position].solved) View.VISIBLE else View.INVISIBLE
    }

    override fun getItemCount() = crimesList.size

    inner class CrimeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.solved)

        init {
            itemView.setOnClickListener {
                val args = Bundle()
                args.putString("detailTitle", crimesList[adapterPosition].title)
                args.putString("detailContent", "Description: ${crimesList[adapterPosition].content}")
                args.putString("detailIndex", "Index: ${crimesList[adapterPosition].index}")
                args.putString("detailSolved", if (crimesList[adapterPosition].solved) "Solved: YES" else "Solved: NO")

                Navigation.findNavController(itemView).navigate(R.id.to_fragmentDetail, args)
            }
        }
    }
}