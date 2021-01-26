package com.bookandgo.domain.contracts.presenters

import com.bookandgo.domain.contracts.presenters.holders.UseCasePresenterHolder
import com.bookandgo.domain.contracts.UseCaseResponse

interface  IUseCasePresenter<Response: UseCaseResponse<*>> {

    var holder: UseCasePresenterHolder
    suspend fun present(response: Response)

}