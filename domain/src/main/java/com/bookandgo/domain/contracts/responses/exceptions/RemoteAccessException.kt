package com.bookandgo.domain.contracts.responses.exceptions

open class RemoteAccessException(override val message: String?): DataAccessException(message)