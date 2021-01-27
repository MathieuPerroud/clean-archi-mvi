package com.bookandgo.booking.bookinglist

import com.bookandgo.domain.space.Space

sealed class BookingListPartialState {
    data class SpacesRetrieved(val spaces: List<Space>) : BookingListPartialState()
    data class SpacesNotRetrieved(val message: String?) : BookingListPartialState()
}