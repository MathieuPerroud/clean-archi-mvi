package com.bookandgo.booking.bookinglist.models

import com.bookandgo.domain.booking.Booking

class EffectiveBooking(override val owner: String, override val start: EffectiveSlot,
                       override val end: EffectiveSlot
): Booking(owner, start, end) {
    constructor(booking: Booking) : this(booking.owner, EffectiveSlot(booking.start) , EffectiveSlot(booking.end))
}