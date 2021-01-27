package com.bookandgo.booking.bookinglist


import androidx.recyclerview.widget.LinearLayoutManager
import com.bookandgo.booking.extensions.requireSpacesRecyclerAdapter
import com.bookandgo.booking.bookinglist.adapter.SpacesRecyclerAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookingListFragment : BaseBookingListFragment() {

    override fun setupViews() {
        with(viewBinding) {
            contentBottomSheet.apply {
                initBehavior()
                setPeekHeight(200)
                expand()
            }
            toolbar.setOnClickListener {
                viewModel.dispatchIntent(
                    BookingListIntent.ShowSpaces
                )
            }
            rvPlaces.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = SpacesRecyclerAdapter { space ->
                    viewModel.dispatchIntent(
                        BookingListIntent.SpaceSelected(space)
                    )
                }
            }
        }
    }

    override fun renderState(viewState: BookingListState) {
        with(viewBinding) {
            with(viewState){
                triggeredEvents.apply {
                    forEach { event ->
                        when(event) {
                            is BookingListState.Event.PopSnackBar -> popSnackbar(event.message, Snackbar.LENGTH_LONG)
                            is BookingListState.Event.ToggleBottomSheet ->
                                if (collapsed)contentBottomSheet.expand() else contentBottomSheet.collapse()
                        }
                        poll()
                    }
                }
            }

            rvPlaces.requireSpacesRecyclerAdapter().updateDataList(viewState.spaces)

        }
    }
}