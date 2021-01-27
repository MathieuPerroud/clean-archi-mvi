package com.bookandgo.domain.booking.usecases.getallbookingsofspace

import com.bookandgo.domain.Either
import com.bookandgo.domain.booking.Booking
import com.bookandgo.domain.contracts.IUseCaseResponse
import com.bookandgo.domain.contracts.UseCaseResponse
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import com.bookandgo.domain.contracts.responses.results.IResultSuccess
import com.bookandgo.domain.space.Space

class GetAllBookingsOfSpaceResponse(
    override val result: Either<IResultSuccess<List<Booking>?>, IResultFailure<DataAccessException>>
) : UseCaseResponse<List<Booking>?, DataAccessException>()