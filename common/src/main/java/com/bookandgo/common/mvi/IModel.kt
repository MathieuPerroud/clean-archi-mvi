package com.bookandgo.common.mvi

import kotlinx.coroutines.flow.StateFlow

interface IModel<STATE, INTENT> {

    val state: StateFlow<STATE>

    fun dispatchIntent(intent: INTENT)
}