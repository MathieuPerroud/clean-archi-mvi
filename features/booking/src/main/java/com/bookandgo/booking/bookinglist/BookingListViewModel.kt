package com.bookandgo.booking.bookinglist

import androidx.hilt.lifecycle.ViewModelInject
import com.bookandgo.booking.presenters.getallspaces.GetAllSpacesHandler
import com.bookandgo.booking.presenters.getallspaces.GetAllSpacesPresenter
import com.bookandgo.common.mvi.MVIViewModel
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesRequest
import com.bookandgo.booking.bookinglist.BookingListIntent.*
import com.bookandgo.booking.bookinglist.models.EffectiveSpace
import kotlinx.coroutines.launch


class BookingListViewModel @ViewModelInject constructor(private val getAllSpaces: GetAllSpacesHandler) :
    MVIViewModel<BookingListState, BookingListIntent, BookingListPartialState, BookingListViewModel.Action>
        (BookingListReducer()) {

    init {
        launch {
            handleAction(Action.GetAllSpaces)
        }
    }

    override fun createInitialState() = BookingListState()

    override fun intentToAction(intent: BookingListIntent): Array<Action> {
        return when(intent){
            is SpaceSelected -> arrayOf(Action.SelectSpace(intent.space))
            is ShowSpaces -> arrayOf(Action.SwitchBottomSheetState)
        }
    }

    override fun handleAction(action: Action) {
        launch{
            return@launch when(action){
                is Action.SelectSpace -> {}
                is Action.GetAllSpaces -> {
                    when(val holder = handlingGetAllSpaces()){
                        is GetAllSpacesPresenter.RandomFailureHolder ->
                            stateChannel.send(BookingListPartialState.SpacesNotRetrieved(holder.message))
                        is GetAllSpacesPresenter.SuccessfulHolder ->
                            stateChannel.send(BookingListPartialState.SpacesRetrieved(holder.spaces))
                        else ->  stateChannel.send(BookingListPartialState.SpacesNotRetrieved("What did just happened ?"))
                    }
                }
                is Action.SwitchBottomSheetState -> stateChannel.send(BookingListPartialState.BottomSheetToggled)
            }



        }
    }


    private suspend fun handlingGetAllSpaces() = getAllSpaces.handle(GetAllSpacesRequest(),GetAllSpacesPresenter())
    sealed class Action {
        data class SelectSpace(val space: EffectiveSpace) : Action()
        object GetAllSpaces : Action()
        object SwitchBottomSheetState : BookingListViewModel.Action()
    }
}
