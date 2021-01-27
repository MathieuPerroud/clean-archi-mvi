package com.bookandgo.domain.contracts

import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException

abstract class UseCaseResponse<DataType:Any?, Ex: DataAccessException> : IUseCaseResponse