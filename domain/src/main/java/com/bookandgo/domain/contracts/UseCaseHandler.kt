package com.bookandgo.domain.contracts

import com.bookandgo.domain.contracts.presenters.IUseCasePresenter
import com.bookandgo.domain.contracts.presenters.holders.UseCasePresenterHolder
import com.bookandgo.domain.contracts.requests.IUseCaseRequest
import com.bookandgo.domain.contracts.responses.exceptions.DataAccessException

@Suppress("UNCHECKED_CAST")
abstract class UseCaseHandler<Request: IUseCaseRequest, Response: IUseCaseResponse>
    (private val useCase: IUseCase<Request,Response>){
    open suspend fun handle(request: Request, presenter: IUseCasePresenter<Response>): UseCasePresenterHolder  {
            useCase.execute(request,presenter)
            return presenter.holder
    }
}