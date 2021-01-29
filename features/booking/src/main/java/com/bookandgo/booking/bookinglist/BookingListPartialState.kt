package com.bookandgo.booking.bookinglist

import com.bookandgo.booking.bookinglist.models.EffectiveSpace
import com.bookandgo.domain.space.Space

sealed class BookingListPartialState {
    object BottomSheetToggled : BookingListPartialState()
    data class SpacesRetrieved(val spaces: List<Space>) : BookingListPartialState()
    data class SpacesNotRetrieved(val message: String?) : BookingListPartialState()
    data class NewSpaceSelected(val space: EffectiveSpace) : BookingListPartialState()
}