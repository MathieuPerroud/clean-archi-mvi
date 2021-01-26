package com.bookandgo.booking.list.models

import com.bookandgo.domain.slot.Slot

class EffectiveSlot(override val hours: Int, override val minutes: Int) : Slot(hours, minutes)