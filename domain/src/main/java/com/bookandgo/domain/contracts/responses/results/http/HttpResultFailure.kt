package com.bookandgo.domain.contracts.responses.results.http

import com.bookandgo.domain.contracts.responses.exceptions.RemoteAccessException
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import java.util.*

open class HttpResultFailure<Ex : RemoteAccessException>(
    httpCode: Int,
    date: Date = Date(),
    override val exception: Ex
) : HttpResult(httpCode, date), IResultFailure<RemoteAccessException>