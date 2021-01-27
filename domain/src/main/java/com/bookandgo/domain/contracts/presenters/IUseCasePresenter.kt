package com.bookandgo.domain.contracts.presenters

import com.bookandgo.domain.contracts.presenters.holders.UseCasePresenterHolder
import com.bookandgo.domain.contracts.IUseCaseResponse
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException

interface  IUseCasePresenter<Response: IUseCaseResponse> {
    var holder: UseCasePresenterHolder
    suspend fun present(response: Response)
}