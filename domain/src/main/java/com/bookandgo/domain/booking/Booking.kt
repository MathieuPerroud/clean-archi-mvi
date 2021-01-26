package com.bookandgo.domain.booking

import com.bookandgo.domain.slot.Slot

open class Booking(open val owner: String, open val start: Slot, open val end: Slot )