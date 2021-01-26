package com.bookandgo.booking.list.models

import com.bookandgo.domain.space.Space

open class EffectiveSpace(
    override val name: String,
    override val bookings: List<EffectiveBooking>,
    val available: Boolean,
    val availableSlots: List<EffectiveSlot>,
    val bookedSlots: List<EffectiveSlot>
) :
    Space(name,bookings)