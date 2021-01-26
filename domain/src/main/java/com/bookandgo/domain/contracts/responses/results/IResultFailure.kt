package com.bookandgo.domain.contracts.responses.results

interface IResultFailure<Ex:Exception>: IResult {
    val exception: Ex
}