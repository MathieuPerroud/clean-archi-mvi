package com.bookandgo.booking.bookinglist

import com.bookandgo.booking.bookinglist.models.EffectiveBooking
import com.bookandgo.booking.bookinglist.models.EffectiveSpace
import java.util.*
import java.util.concurrent.ArrayBlockingQueue


data class BookingListState(
    val bookings: List<EffectiveBooking> = emptyList(),
    val placeAvailable: Boolean = false,
    val selectingSpace: Boolean = false,
    val triggeredEvents: Queue<Event> = ArrayBlockingQueue(4),
    val spaces: List<EffectiveSpace> = emptyList(),
    val currentSpace: EffectiveSpace? = null,
    val collapsed: Boolean = true
) {
    sealed class Event {
        data class PopSnackBar(val message: String) : Event()
        object ToggleBottomSheet : Event()
        object UpdateSlotsAvailable : Event()
    }
}