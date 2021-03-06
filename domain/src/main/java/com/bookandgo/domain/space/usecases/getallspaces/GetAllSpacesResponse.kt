package com.bookandgo.domain.space.usecases.getallspaces

import com.bookandgo.domain.Either
import com.bookandgo.domain.contracts.IUseCaseResponse
import com.bookandgo.domain.contracts.UseCaseResponse
import com.bookandgo.domain.contracts.responses.exceptions.RemoteAccessException
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import com.bookandgo.domain.contracts.responses.results.IResultSuccess
import com.bookandgo.domain.contracts.responses.results.http.HttpResultFailure
import com.bookandgo.domain.contracts.responses.results.http.HttpResultSuccess
import com.bookandgo.domain.space.Space

class GetAllSpacesResponse(
    override val result: Either<IResultSuccess<List<Space>?>, IResultFailure<RemoteAccessException>>
) : UseCaseResponse<List<Space>?, RemoteAccessException>()