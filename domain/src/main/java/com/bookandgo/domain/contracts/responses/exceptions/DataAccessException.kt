package com.bookandgo.domain.contracts.responses.exceptions

open class DataAccessException(override val message: String?): Exception(message)