package com.bookandgo.domain.contracts

import com.bookandgo.domain.contracts.presenters.IUseCasePresenter
import com.bookandgo.domain.contracts.requests.IUseCaseRequest
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException
import java.lang.Exception

interface IUseCase<Request: IUseCaseRequest,Response: IUseCaseResponse/*, Presenter: IUseCasePresenter<Response>*/> {
    suspend fun execute(request: Request, presenter: IUseCasePresenter<Response>)
}