package com.bookandgo.booking.bookinglist

import com.bookandgo.booking.bookinglist.models.EffectiveSpace

sealed class BookingListIntent {
    data class SpaceSelected(val space: EffectiveSpace) : BookingListIntent()
}