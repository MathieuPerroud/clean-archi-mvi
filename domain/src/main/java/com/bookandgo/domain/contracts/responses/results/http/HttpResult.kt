package com.bookandgo.domain.contracts.responses.results.http

import com.bookandgo.domain.contracts.responses.results.IResult
import java.util.*

open class HttpResult(open val httpCode: Int, override val date: Date) : IResult