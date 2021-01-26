package com.bookandgo.domain.contracts.responses.exceptions

open class LocalAccessException(override val message: String?): DataAccessException(message)