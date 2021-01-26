package com.bookandgo.domain.contracts.responses.results.http

import com.bookandgo.domain.contracts.responses.results.IResultSuccess
import java.util.*

open class HttpResultSuccess<DataType:Any?>(httpCode: Int, date: Date, override val data:DataType?)
    : HttpResult(httpCode, date), IResultSuccess<DataType>