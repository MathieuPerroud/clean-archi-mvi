package com.bookandgo.domain.booking.usecases.getallbookingsofspace

import com.bookandgo.domain.contracts.requests.ILastUpdateUseCaseRequest

class GetAllBookingsOfSpaceRequest(override val lastUpdate: Int? = null) : ILastUpdateUseCaseRequest