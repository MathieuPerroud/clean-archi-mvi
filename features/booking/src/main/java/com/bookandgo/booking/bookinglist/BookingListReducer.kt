package com.bookandgo.booking.bookinglist

import com.bookandgo.common.mvi.IReducer
import com.bookandgo.booking.bookinglist.BookingListPartialState.*
import com.bookandgo.booking.bookinglist.BookingListState.*
import com.bookandgo.booking.bookinglist.models.EffectiveSpace

class BookingListReducer : IReducer<BookingListState, BookingListPartialState> {
    override fun reduce(
        state: BookingListState,
        partialState: BookingListPartialState
    ): BookingListState {
        return when(partialState){
            is SpacesRetrieved -> state.copy(
                spaces = partialState.spaces.map { space -> EffectiveSpace(space) },
                triggeredEvents = state.triggeredEvents.apply { add(Event.PopSnackBar(""+partialState.spaces.size + " spaces retrieved")) }
            )
            is SpacesNotRetrieved -> state.copy(
                triggeredEvents = state.triggeredEvents.apply { add(Event.PopSnackBar(partialState.message?:"An error occurred")) }
            )
        }
    }
}