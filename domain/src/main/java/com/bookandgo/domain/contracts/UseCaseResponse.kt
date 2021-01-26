package com.bookandgo.domain.contracts

import com.bookandgo.domain.Either
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import com.bookandgo.domain.contracts.responses.results.IResultSuccess

open class UseCaseResponse<DataType:Any?, Ex: DataAccessException>(open val result: Either<IResultSuccess<DataType?>,IResultFailure<Ex>>)