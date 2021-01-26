package com.bookandgo.domain.contracts.responses.results.sqlite

import com.bookandgo.domain.contracts.responses.exceptions.LocalAccessException
import com.bookandgo.domain.contracts.responses.results.IResult
import com.bookandgo.domain.contracts.responses.results.IResultFailure
import java.util.*

open class SQLiteResultFailure<Ex : LocalAccessException>(
    override val exception: Ex,
    override val date: Date
) : IResultFailure<LocalAccessException>