package com.bookandgo.booking.list

import com.bookandgo.booking.list.models.EffectiveBooking
import com.bookandgo.booking.list.models.EffectiveSpace


data class BookingListState(
 val bookings : List<EffectiveBooking> = emptyList(),
 val placeAvailable: Boolean = false,
 val title: String = "",
 val selectingSpace: Boolean = false,
 val spaces: List<EffectiveSpace> = emptyList(),
 val currentSpace: EffectiveSpace? = null
)