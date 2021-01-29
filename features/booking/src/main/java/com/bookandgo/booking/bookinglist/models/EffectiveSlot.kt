package com.bookandgo.booking.bookinglist.models

import com.bookandgo.domain.slot.Slot

class EffectiveSlot(override val hours: Int, override val minutes: Int) : Slot(hours, minutes){
    constructor(slot: Slot) : this(slot.hours, slot.minutes)
}