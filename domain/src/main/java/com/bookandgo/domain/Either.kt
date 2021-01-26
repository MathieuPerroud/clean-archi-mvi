package com.bookandgo.domain

sealed class Either<out S : Any, out F : Any> {

    data class Success<S : Any>(val content: S) : Either<S, Nothing>()
    data class Failure<F : Any>(val content: F) : Either<Nothing, F>()

    suspend fun either(onSuccess: suspend ((S) -> Unit), onFailure: suspend ((F) -> Unit)) {
        when (this) {
            is Success<S> -> onSuccess(content)
            is Failure<F> -> onFailure(content)
        }
    }
}