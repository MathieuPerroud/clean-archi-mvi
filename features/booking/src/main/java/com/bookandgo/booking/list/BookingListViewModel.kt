package com.bookandgo.booking.list

import androidx.hilt.lifecycle.ViewModelInject
import com.bookandgo.booking.presenters.getallspaces.GetAllSpacesHandler
import com.bookandgo.booking.presenters.getallspaces.GetAllSpacesPresenter
import com.bookandgo.common.mvi.MVIViewModel
import com.bookandgo.domain.space.usecases.getallspaces.GetAllSpacesRequest
import com.bookandgo.domain.space.usecases.getonespace.GetOneSpaceRequest
import kotlinx.coroutines.launch


class BookingListViewModel @ViewModelInject constructor(private val getAllSpaces: GetAllSpacesHandler) :
    MVIViewModel<BookingListState, BookingListIntent, BookingListPartialState, BookingListViewModel.Action>
        (BookingListReducer()) {

    init {
        launch {
            handlingGetAllSpaces()
        }
    }

    override fun createInitialState() = BookingListState()

    override fun intentToAction(intent: BookingListIntent): Array<Action> {
        return emptyArray()
    }

    override fun handleAction(action: Action) {
        launch{


            when(val holder = handlingGetAllSpaces()){
                is GetAllSpacesPresenter.NoDataHolder ->{
                    //stop loading send(PartialStateStopLoading)
                    //launch success animation send(LaunchSuccessAnimation)
                    //display info send(SlotSuccessfulyRetrieved)
                    }
                is GetAllSpacesPresenter.RandomFailureHolder -> {}
                is GetAllSpacesPresenter.SuccessfulHolder -> {
                    //stop loading send(PartialStateStopLoading)
                    //launch success animation send(LaunchSuccessAnimation)
                    //display info send(SlotSuccessfulyRetrieved)
                }
            }

        }
    }


    private suspend fun handlingGetAllSpaces() = getAllSpaces.handle(GetAllSpacesRequest(),GetAllSpacesPresenter())
    sealed class Action {

    }
}
