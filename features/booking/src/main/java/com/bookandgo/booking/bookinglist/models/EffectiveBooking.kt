package com.bookandgo.booking.bookinglist.models

import com.bookandgo.domain.booking.Booking

class EffectiveBooking(override val owner: String, override val start: EffectiveSlot,
                       override val end: EffectiveSlot
): Booking(owner, start, end) {
    constructor(booking: Booking) : this(booking.owner, EffectiveSlot(booking.start) , EffectiveSlot(booking.end))

    override fun toString(): String {
        var range = if (start.minutes == 0) {
            "${start.hours}:00"
        } else {
            "${start.hours}:${start.minutes}"
        }
        range = "$range -> " +if (end.minutes == 0) {
            "${end.hours}:00"
        } else {
            "${end.hours}:${end.minutes}"
        }
        return range
    }
}