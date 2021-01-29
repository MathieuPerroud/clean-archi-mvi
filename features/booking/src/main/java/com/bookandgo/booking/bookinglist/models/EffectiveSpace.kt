package com.bookandgo.booking.bookinglist.models

import com.bookandgo.booking.checkIfBetween
import com.bookandgo.booking.getCurrentHour
import com.bookandgo.domain.booking.Booking
import com.bookandgo.domain.space.Space

open class EffectiveSpace(
    override val name: String,
    override val bookings: List<EffectiveBooking>,
    val availableSlots: List<EffectiveSlot>,
    val bookedSlots: List<EffectiveSlot>
) : Space(name, bookings) {
    constructor(
        space: Space,
        availableSlots: List<EffectiveSlot> = emptyList(),
        bookedSlots: List<EffectiveSlot> = emptyList()
    ) : this(
        space.name,
        space.bookings.map { EffectiveBooking(it) },
        availableSlots,
        bookedSlots
    )

    fun getClosestBooking(hours: Int): Booking? =
            this.bookings.firstOrNull { hours<= it.end.hours || it.start.hours >= hours }


    fun isAvailable(): Boolean =
        getClosestBooking(getCurrentHour())?.let{
            !checkIfBetween(it.start, it.end,getCurrentHour(),0)
        }?:false


    fun getAvailabilityDescription() =if(isAvailable())
        "Disponible jusqu'à "+ getClosestBooking(getCurrentHour())?.start.toString()
    else
        "Occupé jusqu'à"+ getClosestBooking(getCurrentHour())?.end.toString()
}