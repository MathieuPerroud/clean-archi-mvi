package com.bookandgo.booking.bookinglist.adapter.slot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bookandgo.booking.R
import com.bookandgo.booking.checkIfBetween
import com.bookandgo.booking.databinding.ItemSlotBinding
import com.bookandgo.domain.booking.Booking
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SlotRecyclerAdapter(mocked: Boolean = false) :
    RecyclerView.Adapter<SlotRecyclerAdapter.ViewHolder>() {

    private var slots = ArrayList<SlotItem>()
    private lateinit var currentSlot: SlotItem

    init {
        val cal = Calendar.getInstance()
        var hour = cal.get(Calendar.HOUR_OF_DAY)
        val minutes: Int
        if (cal.get(Calendar.MINUTE) > 30) {
            hour += 1
            minutes = 0
        } else {
            minutes = 30
        }
        currentSlot = if (mocked) SlotItem(hours = 8, minutes = 0) else SlotItem(
            true,
            hour,
            minutes
        )
        generateAllSlotsToMidnight()
        // fill slots per 30 mins
    }

    private fun generateAllSlotsToMidnight() {
        slots = ArrayList()
        slots.apply {
            add(currentSlot)
            while (!(last().hours == 23 && last().minutes == 30)) {
                val newSlot =
                    if (last().minutes == 0) {
                        SlotItem(hours = last().hours, minutes = 30)
                    } else {
                        SlotItem(hours = last().hours + 1, minutes = 0)
                    }
                add(newSlot)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_slot,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProduct(slots[position])
    }

    override fun getItemCount(): Int = slots.size


    fun filterWithBookings(bookings: List<Booking>) {
        //filter bookings of the day
        slots.forEach { it.available = true }
        bookings.forEach { booking ->
            slots.filter { slot ->
                checkIfBetween(
                    booking.start.hours,
                    booking.start.minutes,
                    booking.end.hours,
                    booking.end.minutes,
                    slot.hours,
                    slot.minutes
                )
            }.forEach {
                it.available = false
            }
        }
        notifyDataSetChanged()
    }



    class ViewHolder(private val itemBinding: ItemSlotBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindProduct(item: SlotItem) {
            itemBinding.slot = item
            itemBinding.value.text = item.toString()
        }
    }
}
