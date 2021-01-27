package com.bookandgo.booking.bookinglist.models

import com.bookandgo.domain.space.Space

open class EffectiveSpace(
    override val name: String,
    override val bookings: List<EffectiveBooking>,
    val available: Boolean,
    val availableSlots: List<EffectiveSlot>,
    val bookedSlots: List<EffectiveSlot>
) : Space(name, bookings) {
    constructor(
        space: Space,
        available: Boolean = false,
        availableSlots: List<EffectiveSlot> = emptyList(),
        bookedSlots: List<EffectiveSlot> = emptyList()
    ) : this(space.name, space.bookings.map { EffectiveBooking(it) }, available,availableSlots, bookedSlots)
}