package com.bookandgo.booking.bookinglist

import com.bookandgo.booking.R
import com.bookandgo.booking.BR
import com.bookandgo.booking.databinding.BookingListFragmentBinding
import com.bookandgo.common.extensions.popSnackbar
import com.bookandgo.common.mvi.MVIFragment

//https://github.com/google/dagger/issues/1904
//Dagger2>Koin>Hilt too much issues when you want to abstract your job
//@AndroidEntryPoint cannot have direct abstract parent with inferred Types ... lame :(
//https://github.com/google/dagger/issues/1910
abstract class BaseBookingListFragment: MVIFragment<BookingListState, BookingListIntent, BookingListFragmentBinding, BookingListViewModel>(
    R.layout.booking_list_fragment,
    BR.viewmodel,
    BookingListViewModel::class
) {
    fun popSnackbar(message: String, duration: Int) =
        requireView().popSnackbar(message, duration)
}