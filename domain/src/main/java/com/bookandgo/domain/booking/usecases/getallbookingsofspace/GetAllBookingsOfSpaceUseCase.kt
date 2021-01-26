package com.bookandgo.domain.booking.usecases.getallbookingsofspace

import com.bookandgo.domain.booking.IBookingRepository
import com.bookandgo.domain.contracts.IUseCase
import com.bookandgo.domain.contracts.presenters.IUseCasePresenter

class GetAllBookingsOfSpaceUseCase(private val bookingRepository: IBookingRepository): IUseCase<GetAllBookingsOfSpaceRequest, GetAllBookingsOfSpaceResponse> {
    override suspend fun execute(request: GetAllBookingsOfSpaceRequest, presenter: IUseCasePresenter<GetAllBookingsOfSpaceResponse>) {


    }
}