package com.bookandgo.booking.list.models

import com.bookandgo.domain.booking.Booking
import com.bookandgo.domain.slot.Slot

class EffectiveBooking(override val owner: String, override val start: EffectiveSlot,
                       override val end: EffectiveSlot): Booking(owner, start, end) {
}