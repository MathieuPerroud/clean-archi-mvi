package com.bookandgo.booking.list

import com.bookandgo.common.mvi.IReducer

class BookingListReducer : IReducer<BookingListState, BookingListPartialState> {
    override fun reduce(
        state: BookingListState,
        partialState: BookingListPartialState
    ): BookingListState {
        return BookingListState()
    }
}