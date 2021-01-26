package com.bookandgo.domain.contracts.responses.exceptions

open class RemoteTimeoutException(override val message: String = "Timeout"): RemoteAccessException(message)