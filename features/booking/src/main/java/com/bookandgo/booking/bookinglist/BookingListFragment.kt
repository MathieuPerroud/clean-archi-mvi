package com.bookandgo.booking.bookinglist


import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookandgo.booking.extensions.requireSpacesRecyclerAdapter
import com.bookandgo.booking.bookinglist.adapter.SpacesRecyclerAdapter
import com.bookandgo.booking.bookinglist.adapter.slot.SlotRecyclerAdapter
import com.bookandgo.booking.extensions.getTypedAdapter
import com.bookandgo.booking.getCurrentHour
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.booking_list_reservation_space.*

@AndroidEntryPoint
class BookingListFragment : BaseBookingListFragment() {

    override fun setupViews() {
        with(viewBinding) {
            contentBottomSheet.initBehavior().expand()

            cmdList.setOnClickListener {
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
            rvSlots.apply {
                layoutManager = GridLayoutManager(context, 8)
                adapter = SlotRecyclerAdapter()
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
                            is BookingListState.Event.ToggleBottomSheet -> {
                                contentBottomSheet.apply {
                                    val h = requireActivity().windowManager.defaultDisplay.height - rvPlaces.bottom
                                    setPeekHeight(if (h>300)h else 300)
                                    if (collapsed)expand() else collapse()
                                }

                            }
                            is BookingListState.Event.UpdateSlotsAvailable -> rvSlots.getTypedAdapter<SlotRecyclerAdapter>().filterWithBookings(currentSpace?.bookings?: emptyList())
                        }
                        poll()
                    }
                }

                val closestBooking = currentSpace?.getClosestBooking(getCurrentHour())
                toolbar.title = currentSpace?.name ?:"Sélectionnez un espace"
                toolbar.subtitle = currentSpace?.getAvailabilityDescription() ?: ""
                tvAvailability.text = currentSpace?.getAvailabilityDescription() ?: ""
                tv_booker.text ="Promoteur : "+ closestBooking?.owner
                tv_next_availability.text = "Prochaine réservation : "+closestBooking?.toString()
            }
            rvPlaces.requireSpacesRecyclerAdapter().updateDataList(viewState.spaces)


        }
    }
}