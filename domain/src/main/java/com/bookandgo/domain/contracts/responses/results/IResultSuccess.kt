package com.bookandgo.domain.contracts.responses.results

interface IResultSuccess<DataType:Any?> :IResult {
    val data:DataType?
}