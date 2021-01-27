package com.bookandgo.domain.contracts

import com.bookandgo.domain.Either
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import com.bookandgo.domain.contracts.responses.results.IResultSuccess

interface IUseCaseResponse{
    val result: Either<*,*>
}