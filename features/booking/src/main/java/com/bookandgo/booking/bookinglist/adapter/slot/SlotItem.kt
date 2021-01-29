package com.bookandgo.booking.bookinglist.adapter.slot

import com.bookandgo.domain.slot.Slot

data class SlotItem(var available: Boolean = true, override val hours: Int, override val minutes: Int): Slot(hours, minutes) {
    override fun toString(): String {
        return super.toString()
    }
}