package com.bookandgo.domain.space.usecases.getonespace

import com.bookandgo.domain.Either
import com.bookandgo.domain.contracts.IUseCaseResponse
import com.bookandgo.domain.contracts.UseCaseResponse
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import com.bookandgo.domain.contracts.responses.results.IResultSuccess
import com.bookandgo.domain.space.Space

class GetOneSpaceResponse(
    override val result: Either<IResultSuccess<Space?>, IResultFailure<DataAccessException>>
) : UseCaseResponse<Space, DataAccessException>()