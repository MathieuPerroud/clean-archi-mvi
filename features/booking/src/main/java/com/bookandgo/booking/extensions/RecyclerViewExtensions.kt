package com.bookandgo.booking.extensions

import androidx.recyclerview.widget.RecyclerView
import com.bookandgo.booking.bookinglist.adapter.SpacesRecyclerAdapter

fun RecyclerView.requireSpacesRecyclerAdapter() = getTypedAdapter<SpacesRecyclerAdapter>()
fun <T: RecyclerView.Adapter<*>> RecyclerView.getTypedAdapter() = this.adapter as T