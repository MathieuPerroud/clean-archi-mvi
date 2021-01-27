package com.bookandgo.booking.bookinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bookandgo.booking.R
import com.bookandgo.booking.bookinglist.models.EffectiveSpace
import kotlinx.android.synthetic.main.item_space.view.*
import kotlin.collections.ArrayList


class SpacesRecyclerAdapter(private val spaceSelected: (EffectiveSpace) -> Unit) : RecyclerView.Adapter<SpacesRecyclerAdapter.ViewHolder>(){

    private var spaces = ArrayList<EffectiveSpace>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_space,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProduct(spaces[position], spaceSelected)
    }
    override fun getItemCount(): Int = spaces.size
    
    fun updateDataList(newData: List<EffectiveSpace>) {
        spaces = ArrayList(newData.sortedBy { s -> s.available })
        notifyDataSetChanged()
    }
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindProduct(item: EffectiveSpace, spaceSelected: (EffectiveSpace) -> Unit ) {
            view.name.text = item.name
            view.availability.text = if (item.available)"Disponible" else "Occupé"

        }
    }
}
